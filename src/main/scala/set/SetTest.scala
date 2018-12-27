package set

object SetTest {
  def main(args: Array[String]): Unit = {
    println("SetTest")

    val a:Set[Int] = Set(1,2,2,3)
    println(a)

    val fruit = Set("apple", "banana", "fineapple")
    println("Head: " + fruit.head)
    println("Tail: " + fruit.tail)

    val aa = (fruit ++ a)
    println("Concat: " + aa)
    println("IsEmpty: " + aa.isEmpty)
    println("MAx: " + a.max)
    //println("MAx: " + aa.max) //Error

    val bb =  a.intersect(Set(1,2,5,6,7,8)) //교차 되는값을 찾는다.
    println("Insert: " + bb)
    println(a.&(Set(1,2,5,6,7,8)))

    println(a+5)
  }
}
