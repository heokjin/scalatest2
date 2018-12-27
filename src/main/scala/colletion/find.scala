package colletion

object find {
  //find는 리스트에서 술어함수를 만족하는 가장 첫 원소를 반환한다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    val a = numbers.find((i:Int)=> i>2)
    println(a)

  }
}
