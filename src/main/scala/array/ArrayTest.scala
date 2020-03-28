package array

import com.twitter.util.Future

import Array._

object ArrayTest {
  /***x
  성능차이
  Array  List
    Access the ith element    O(1)   O(i)
  Delete the ith element    O(n)   O(i)
  Insert an element at i    O(n)   O(i)
  Reverse                   O(n)   O(n)
  Concatenate (length m,n)  O(n+m) O(n)
  Count the elements        O(1)   O(n)
  메모리 차이

  Array  List
    Get the first i elements  O(i)   O(i)
  Drop the first i elements O(n-i) O(1)
  Insert an element at i    O(n)   O(i)
  Reverse                   O(n)   O(n)
  Concatenate (length m,n)  O(n+m) O(n)

  따라서 빠른 임의 액세스가 필요하거나 요소를 계산해야하는 경우가 아니라면 List 가 Array 보다 낫습니다.
  ***/
  def main(args: Array[String]): Unit = {
    val str = "3.5.3/30503 ios/12.1.2"
    val arr = str.split(" ")
    val m1 = arr.map(_.split("/"))
    val f1 = m1.flatten
    println(m1.length)
    println(m1(0)(1))
    println(m1(1)(0))

    val ss = Some("1")

    val testArr =  ss.flatMap(s => fromString(s))
    println(testArr)

    val myList01 = Array[String]()
    myList01 match {
      case Array(first, _*) => println("First => " + first)
      case _ => println("@@@")
      case Array() => println("!!!")
    }

    val myList0 = (1.9, 2.9, 3.4, 3.5)
    println(myList0._1)

    val myList = Array(1.9, 2.9, 3.4, 3.5)
    for (x <- myList) {
      print(x + ", ")
    }
    println("\n")

    var total = 0.0
    for(i<-0 to (myList.length)-1) {
      total += myList(i)
    }
    println("Total: " + total)

    var max = myList(0)
    for(i<-0 to (myList.length)-1) {
      if (myList(i) > max)
        max = myList(i)
    }
    println("MAx: " + max)

    //2차원 배열
    var myMatrix = ofDim[Int](3,3)
    for (i<-0 to 2; j<-0 to 2) {
      myMatrix(i)(j) = j
    }
    for(i<-0 to 2; j<-0 to 2) {
      print(" " + myMatrix(i)(j))
    }
    println()

    //Array concatenate
    val AA = Array(1,2,3)
    val AB = Array(4,5,6)
    val AC = concat(AA, AB)
    for(a <- AC) print(a)
    println("\n")

    val sum = AA ++ AB
    println(sum.length)

    //Array auto stesp
    val Step1 = range(10,20,2) //20까지 찍히진 않는다.
    val Step2 = range(10,20)
    println(Step1.foreach(f => print(" " + f.toString)))
    println(Step2.foreach(f => print(" " + f)))

    val gate = Array[Double]()
    gate match {
      case Array(x, y) => println("AA")
      case null => println("BB")
      case _ => println("DD") //이거라도 있어야 에러가 안남
//      case Array() => println("CC") //이 라인이 없으면 match에러가 난다.
    }

  }

  def fromString(str: String) = {
    str match {
      case "1" =>  Some("ABC")
      case _ => None
    }

  }
}

