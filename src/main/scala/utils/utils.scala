package utils

def readInput(that: Any): String =
  os.read(os.pwd / "src" / "main" / "scala" / that.getClass().getPackage().getName() / "input.txt")

