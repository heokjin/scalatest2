package colletion

object partition {
  //partition은 술어 함수가 반환하는 값에 따라 리스트를 둘로 나눈다.
  //분리이며 한 원소가 양쪽에 속할수는 없다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val a = numbers.partition(_%2 == 0)
    println(a)
  }
}
