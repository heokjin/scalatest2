package option

import scala.util.{Failure, Success, Try}

object OptionTest {
  def main(args: Array[String]): Unit = {
    val capitals = Map("korea" -> "seoul", "japan"->"tokyo", "france"->"paris")

    println(capitals.get("korea"))
    println(capitals.get("korea1"))

    println("Option: " + show(capitals.get("Red1")))

    val appName: Option[String] = null
    val a:Option[Int] = Some(5)
    val b:Option[Int] = None
    val c:Option[String] = appName
    val d:Option[Long] = Some(111L)
    println(d.isDefined)
    println(a.getOrElse(0))
    println(b.getOrElse(0))
    println(a)
    println("===")
    println(Some(c))
    println(Some(c).getOrElse("A"))
    println(c.getOrElse(5))
    println(c.isEmpty)

//    test1()
  }

  def show(x:Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

  def test1(): Unit = {
    val a = NaviDS("A", Some("판교공영주차장 입구|127.110699376457,37.393643067895|8|516523;판교공영주차장 입구1|127.110699376457,37.393643067895|8|516523"))

    val naviGates = parseGates(a.knaviGuideinfo)
    println(naviGates)
    val gate = naviGates match {
      case Some(list) => list.headOption
      case None => None
    }
    println(gate)

    val gainfo = GuideInfo("GATE1", "G", 1.11, 2.11)
    val gainfo1 = GuideInfo("GATE2", "G1", 1.22, 2.22)
    val arr = Option(Array(gainfo, gainfo1))
    println(parseGates2(arr))
  }

  def parseGates2(knaviGuideInfos: Option[Array[GuideInfo]]): Option[Gate] = {
    knaviGuideInfos match {
      case Some(Array()) => {println("A"); Option.empty}
      case Some(Array(arr, _*)) => {println("B"); Option(Gate(arr.y, arr.x, arr.name, arr.rpFlag))}
      case None => {println("C"); Option.empty}
    }
  }

  def parseGates(knaviGuideinfo: Option[String]): Option[Array[Gate]] = {
    knaviGuideinfo match {
      case Some("") => Option.empty
      case Some(infos) => Try(
        Option(infos.split(";")
          .map(info => info.split("\\|"))
          .map(arr => Gate(arr(1).split(",")(1).toDouble, arr(1).split(",")(0).toDouble, arr(0), arr(2)))))
      match {
        case Success(gates) => gates
        case Failure(e) => {
          println(s"navi - gate parse error : ${infos} ")
          Option.empty
        }
      }
      case None => Option.empty
    }
  }

}

case class NaviDS(docid: String, knaviGuideinfo: Option[String])
case class Gate(lat: Double, lng: Double, name: String, flag: String)
case class GuideInfo(name: String, rpFlag: String, x: Double, y: Double)