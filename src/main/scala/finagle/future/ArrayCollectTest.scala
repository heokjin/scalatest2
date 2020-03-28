package finagle.future

object ArrayCollectTest {

  def main(args: Array[String]): Unit = {
    print("TEST")

    val a = TaxiRangeFare(TaxiVerticalKind.BLACK, 1, 2, 3)
    val b = TaxiRangeFare(TaxiVerticalKind.PURPLE, 1, 2, 3)
    val c = Array(TaxiRangeFare(TaxiVerticalKind.TAXI_DELUXE, 1, 2, 3), TaxiRangeFare(TaxiVerticalKind.TAXI_LARGE, 1, 2, 3))

    val d  = c :+ a
    print(d)
  }

}

case class TaxiRangeFare(`type`: TaxiVerticalKind, base: Int, minimum: Int, maximum: Int)

