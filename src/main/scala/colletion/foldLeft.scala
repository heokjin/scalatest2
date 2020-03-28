package colletion

object foldLeft {
  //0은 시작 값이고(numbers가 List[Int]라는 사실을 기억하라), m은 값을 누적하는 변수 역할을 한다.
  //앞의 원소에 함수를 적용한 결과값이 전달되는 위치가 m이라는 의미
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4,5,6,7,8,9,10)
    val a = numbers.foldLeft(0)((m:Int, i:Int) => m+i)
    println(a)

    val aa = numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + ", n: " + n); m + n }
    println(aa)
  }
}
