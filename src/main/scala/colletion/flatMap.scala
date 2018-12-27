package colletion

object flatMap {
  //flatMap은 map과 flatten을 합성한 것이다. 내포 리스트에 적용할 수 있는 함수를 중첩된 리스트 안의 각 리스트에 적용해서 나온 결과를 하나의 리스트로 합쳐준다.
  def main(args: Array[String]): Unit = {
    val l1 = List(List(1,2), List(3,4))
    val a = l1.flatMap(x => x.map(_*2))
    println(a)

    val b = l1.map((x:List[Int]) => x.map(_*2)).flatten
    println(b)

  }
}
