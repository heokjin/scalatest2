package map


object MapTest {
  def main(args: Array[String]): Unit = {
    var tm:Map[String, String] = Map()
    var colorMap = Map("red" -> "#f1111", "black" -> "f0000")
    println(colorMap)
    println(colorMap("red"))
//    println(colorMap("red1")) //Error
    println(colorMap.get("red1"))
    println(colorMap.contains("Red"))

    colorMap += "blue" -> "f22222"
    println(colorMap)
    println("Keys: " + colorMap.keys)
    println("Values: " + colorMap.values)

    tm += ("yello" -> "f77777")
    println("Concat: " + (tm++colorMap))

    val statusColorForBike = Map(
      "abc" -> StatusColor.COLOR_1,
      "def" -> StatusColor.COLOR_2)

    println(statusColorForBike.getOrElse("abc", "A"))
    println(statusColorForBike.getOrElse("abcd", "A"))
    println("----------------------")
    statusColorForBike.filter(_._2.equals(StatusColor.COLOR_1)).map(a => {print(a)})

  }


}

