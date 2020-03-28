package enumtest

import enumtest.EnumTest.getRangeFare

object EnumTest {
  def main(args: Array[String]): Unit = {

    case class TaxiVerticalInfo(taxiKind: TaxiKind, chargeExtra: Boolean)
    val m = Map(
      TaxiVerticalKind.TAXI_MEDIUM -> TaxiVerticalInfo(TaxiKind.MEDIUM, true),
      TaxiVerticalKind.TAXI_LARGE -> TaxiVerticalInfo(TaxiKind.LARGE, true),
      TaxiVerticalKind.TAXI_DELUXE -> TaxiVerticalInfo(TaxiKind.DELUXE, true),
      TaxiVerticalKind.BLACK -> TaxiVerticalInfo(TaxiKind.LUXURY, false),
      TaxiVerticalKind.PURPLE -> TaxiVerticalInfo(TaxiKind.PURPLE, false),
      TaxiVerticalKind.VAN -> TaxiVerticalInfo(TaxiKind.VAN, false))

    val v = Seq(TaxiVerticalKind.BLACK, TaxiVerticalKind.PURPLE, TaxiVerticalKind.TAXI_MEDIUM)

    val f = v.map(t => {
      val taxiVerticalInfo = m(t)
      getTaxiRangeFare(taxiVerticalInfo.taxiKind, t, taxiVerticalInfo.chargeExtra)
    }).foldLeft(Array[TaxiRangeFare]())((m,n) => m++n)


    println(f.mkString)
  }

  def getTaxiRangeFare(kind: TaxiKind, vKind: TaxiVerticalKind, chargeExtra: Boolean): Array[TaxiRangeFare] = {
    val f = if (chargeExtra) getRangeFare(11) else getRangeFare(22)
    Array(TaxiRangeFare(vKind, f.base, f.minimum, f.maximum))
  }

  def getRangeFare(toll: Int): RangeFare = {
    val minimum = toll
    val maximum = minimum + (minimum * 0.1f).toInt + toll
    RangeFare(toll, won(minimum, 100), won(maximum, 100))
  }

  def won(won: Int, scale: Int): Int = (won / scale) * scale

}


case class TaxiRangeFare(`type`: TaxiVerticalKind, base: Int, minimum: Int, maximum: Int)
case class RangeFare(base: Int, minimum: Int, maximum: Int)
