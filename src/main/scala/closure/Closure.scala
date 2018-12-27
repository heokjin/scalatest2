package closure

object Closure {
  def main(args: Array[String]): Unit = {
    println("Closure Test")

    var factor = 3
    val multiplier = (i:Int) => i * factor

    println("Multiplier 3: " + multiplier(3))
  }
}
