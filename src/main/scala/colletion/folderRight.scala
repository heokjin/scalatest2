package colletion

object folderRight {
  //foldLeft와 마찬가지이지만, 동작 방향이 반대이다. 따라서, n에 값이 누적된다.
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4,5,6,7,8,9,10)

    numbers.foldRight(0) {
      (m:Int, n:Int) => println("m: " + m + " n: " + n);
        m+n
    }
  }
}
