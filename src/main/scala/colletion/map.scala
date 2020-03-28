package colletion

object map {
  //List를 반환한다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    numbers.map((i: Int) => print(i))
    println()
    val b = numbers.map((i: Int) => i * 2)
    println(b)

    val c = numbers.map(timesTwo _)
    println(c)

    val bike1 = Bike(1, "A")
    val bike2 = Bike(2, "B")
    val bike3 = Bike(3, "C")
    val bike4 = Bike(4, "D")
    val a1 = Array(bike1, bike2)
    val a2 = Array(bike3, bike4)
    println(a1(1))
//    val aa  = a.map(d => d + ("A" -> ProductCode.BIKE)


    val ar = Array.concat(
      a1.map(d => d),
      a2.map(d => d)
    )
//    aa.map(a => println(a))

    println(ar.mkString)

  }

  def timesTwo(i: Int): Int = i*2

  case class Bike(a: Int, b: String)
}

object ProductCode extends Enumeration {
  type ProductCode = Value
  val TAXI, BLACK, DRIVER, PARKING, NAVI, BUSINESS, CARPOOL, JAPAN_TAXI, SPLYT, BIKE, RBLACK, BOOKING_WEB, GLOBALBOOKING = Value

}