package day_03

val MulRegex         = "mul\\((\\d+),(\\d+)\\)".r
val BetweenDoAndDont = "(^|do\\(\\)).*?($|don't\\(\\))".r

def calculateAllMul(input: String): Long =
  MulRegex.findAllMatchIn(input).map(m => m.group(1).toInt * m.group(2).toInt).sum

@main
def part_01(): Unit =
  println(calculateAllMul(utils.readInput(this)))
end part_01

@main
def part_02(): Unit =
  println(BetweenDoAndDont.findAllIn(utils.readInput(this)).map(calculateAllMul).sum)
end part_02
