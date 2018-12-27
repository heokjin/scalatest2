package kakao

import java.util.regex.{Matcher, Pattern}

object Coding2 {
  val S: Int = 1
  val D: Int = 2
  val T: Int = 3

  def main(args: Array[String]): Unit = {
    val input: String = "1T2D3D#"
    val string = "(\\d+)([SDT*#][SDT*#]?)"
    val matcher = Pattern compile(string) matcher(input)

    var total = List[Int]()
    while (matcher.find()) {
      val matchString = matcher.group()
      var score = calculationScore(matchString)
      convertSpecial(matchString) match {
        case "*" => {
          score = score * 2
          if(total.length >= 1) {
            val c = total.length-1
            total = total.updated(c, total(c) * 2)
          }
        }
        case "#" => score = score * -1
        case None =>
      }
      println("S: " + score)
//      total = score :: total
      total = total :+ score
      println(matchString)
      println(total)
    }
    println(total.foldLeft(0)((i:Int,j:Int)=> i+j))
  }

  def calculationScore(s: String): Int = {
    val i = convertInteger(s)
    convertSDT(s) match {
      case "S" => root(i, S, i)
      case "D" => root(i, D, i)
      case "T" => root(i, T, i)
    }
  }

  def convertInteger(s: String): Int = "\\d+".r.findFirstIn(s).get.toInt
  def convertSDT(s: String): String = "[SDT]".r.findFirstIn(s).get
  def convertSpecial(s: String) = "[*#]".r.findFirstIn(s).getOrElse(None)

  def root(i: Int, j:Int, k:Int):Int = {
    if (j<= 1) return i
    root(i*k, j-1, k)
  }
}
