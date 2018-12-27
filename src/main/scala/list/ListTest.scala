package list

object ListTest {
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
    //List는 Array와 다르게 immutable하고 linked listd이다.
    println("List Test")

    val fruit:List[String] = List("apple", "banana")
    var nums:List[Int] = List(1,2,3,4,5,10,12)
    val emptyList:List[Nothing] = List()
    val dim:List[List[Int]] =
      List(
        List(1,0,0),
        List(0,1,1),
        List(1,1,0)
      )
    val fruit2 = "apple" :: "banana" :: Nil
    var nums2 = 1 :: 2 :: 3 :: Nil
    val dim2 = (1::0::0::Nil) ::
      (0::1::1::Nil) ::
      (1::0::0::Nil) :: Nil
    println("dim2: " + dim2)
    nums2 = nums2.updated(0,5)
    println("test: " + nums2(0)) //3은 안됨
    println("test: " + nums2.length)  //3

    nums = nums :+ 13  //뒤에다 붙이기

    val concatList = fruit ::: nums
    println(concatList)

    val fruitFill = List.fill(3)("apple")

    //Tabulation Function
    val ta = List.tabulate(4)(n => n*n)
    println(ta)
    val mul = List.tabulate(4,5)(_*_)
    println(mul)

    println(mul.reverse)
    println("DROP", ta.drop(1))
    println("DropRight", ta.dropRight(1)) //Returns all elements except last n ones.
    println("DropWhile: " , nums.dropWhile((i:Int) => i==2))
    println("Filter: " + ta.filter((i:Int) => i==0))
    println("Zip: " + nums.zip(List(1,2,3)))
    println("Partition: " + nums.partition(_==2)) //equal 아래랑
    println("Partition: " + nums.partition((i:Int) => i==0))
    println("Partition: " + nums.partition((i:Int) => i%2 == 0))
    println("Find: " + nums.find(_==10))
    println("Find: " + nums.find(_==11))

    val fl = List[Int](3,6,9)
    val ret = fl.foldLeft(0)(_+_)
    println(ret)
    println(fl.foldLeft(0){(x:Int, y:Int) => println(x + ", " + y); (x-y)})
    println(fl.foldRight(0){(x:Int, y:Int) => println(x + ", " + y); (x-y)})

  }
}
