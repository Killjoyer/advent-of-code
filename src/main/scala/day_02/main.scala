package day_02

val lines: List[List[Int]] =
  utils.readInput(this).split("\n").map(_.split(" ").map(_.trim.toInt).toList).toList

enum Pattern:
  case Unknown
  case Ascending
  case Descending

def isSafe(route: List[Int]): Boolean =
  route
    .foldLeft((-1, true, Pattern.Unknown)) {
      case ((prev, false, pattern), _)                                        => (prev, false, pattern)
      case ((-1, r, p), e)                                                    => (e, r, p)
      case ((prev, _, p), e) if prev == e                                     => (e, false, p)
      case ((prev, true, Pattern.Ascending | Pattern.Unknown), e) if prev < e => (e, e - prev < 4, Pattern.Ascending)
      case ((prev, true, Pattern.Descending | Pattern.Unknown), e) if prev > e =>
        (e, prev - e < 4, Pattern.Descending)
      case ((prev, true, p @ Pattern.Ascending), e) if prev >= e  => (e, false, p)
      case ((prev, true, p @ Pattern.Descending), e) if prev <= e => (e, false, p)
    }
    ._2
end isSafe

@main
def part_01(): Unit =
  println(lines.count(isSafe))
end part_01

def tryRemoveEach[A](list: List[A]): List[List[A]] = // 1 2 3 -> 2 3, 1 3, 1 2
  val indexed = list.zipWithIndex
  for {
    (e, i) <- indexed
  } yield indexed.filter(_._2 != i).map(_._1)

@main
def part_02(): Unit =
  def complexIsSafe(list: List[Int]): Boolean =
    tryRemoveEach(list).exists(isSafe)

  println(lines.count(complexIsSafe))
end part_02
