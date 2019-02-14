package colletion

object breaktest {
  def main(args: Array[String]): Unit = {
    val list1 : List[String] = List("ab", "cd")
    val map : Map[Int,String] = list1.map(x => (x.length, x))(collection.breakOut)
    println(map)

    val list2 : List[(Int,String)] = list1.map(x => (x.length, x))
    println(list2)

    val list3 = list1.map(x => (x.length, x))  //위와 같다.
    println(list3)

    val a1 = list1.map(r => {
      (0 to r.length).zip(r)
    })
    println(a1)

    val a = list1.map(r => {
      (0 to r.length).zip(r).map(_ => {
        SuggestPlace(1,"id1","name",1.1,2.2)
      })
    })
    println(a)
  }
}

case class SuggestPlace(idx: Int,
                        id: String,
                        name: String,
                        lat: Double,
                        lng: Double)