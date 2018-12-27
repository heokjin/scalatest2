package colletion

object drop {
  //drop은 첫 i개의 원소를 떨군다. 따라서 나머지 (원래 리스트 길이-i)개의 원소만 남는다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4)
    val a = numbers.drop(2)
    println(a)

    //dropWhile은 리스트의 앞에서 술어함수를 만족하는 원소를 없앤다. 술어함수가 최초로 거짓을 반환하면 그 뒤의 원소들은 살아 남는다.
    val b = numbers.dropWhile(_%2 != 0)
    println(b)
  }
}
