package colletion

object zipped {
  def main(args: Array[String]): Unit = {
    val n: Int = 5
    val arr1: List[Int] = List(9, 20, 28, 18, 11)
    val arr2: List[Int] = List(30, 1, 21, 17, 28)

    var resultList = List[String]()
    (arr1, arr2).zipped.foreach((x,y) => {
      println(x, y)
      val resultString = makeSecurityMap(Integer.toBinaryString(x|y))
      resultList = resultString :: resultList
    })

    println(makeFinalResult(resultList))
  }

  def makeFinalResult(l: List[String]): String = {
    var finalResult = List[String]()
    for(str <- l) {
      finalResult = "\""+str+"\"" :: finalResult
    }
    finalResult.mkString("[", ",", "]")
  }

  def makeSecurityMap(s:String): String = s replaceAll("1", "#") replaceAll("0", " ")
}
