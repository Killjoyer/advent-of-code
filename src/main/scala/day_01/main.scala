package day_01

val lists = utils
  .readInput(this)
  .split("\n")
  .map(_.split("   ").map(_.trim))
  .transpose

@main
def part_1(): Unit =
  println(
    lists(0).sorted
      .zip(lists(1).sorted)
      .map((l, r) => math.abs(l.toInt - r.toInt))
      .sum
  )

@main
def part_2(): Unit =
  val right = lists(1).groupMapReduce(identity)(_ => 1)(_ + _)
  println(lists(0).foldLeft(0)((acc, e) => acc + right.getOrElse(e, 0) * e.toInt))
