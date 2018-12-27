package fortest

object ForTest {
  def main(args: Array[String]): Unit = {
    println("For test")

    //var a = 0

    for(a<-1 to 5) {
      println("A:" + a)
    }

    for(a<-1 until 5) {
      println("A:" + a)
    }

    for(a<-1 to 3; b<-1 to 3) {
      println("A:" + a + ", B:" + b)
    }

    val number = List(1,2,3,4,5,6)
    for(a <- number) {
      print(a)
    }
    println("///")
    for(a <- number
      if a!=3; if a<5) {
      println(a)
    }

    var retVal = for{a<-number if a!=2; if a<5} yield a //값을 저장해 놓는다.
    for(a<-retVal) println(a)
  }
}
