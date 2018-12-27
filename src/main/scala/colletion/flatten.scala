package colletion

object flatten {
  //flatten은 내포단계를 하나 줄여서 내포된 리스트의 원소를 상위 리스트로 옮겨준다.
  def main(args: Array[String]): Unit = {
    val L1 = List(List(1,2), List(3,4))
    val a = L1.flatten
    println(a)
  }
}
