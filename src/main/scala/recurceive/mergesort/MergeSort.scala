package recurceive.mergesort

object MergeSort {
  def main(args: Array[String]): Unit = {
    val a = msort((x:Int, y:Int) => x<y)(List(5,7,1,3))
    println(a)

  }

  def msort[t](less: (t, t) => Boolean)(xs: List[t]): List[t] = {
    def merge(xs: List[t], ys: List[t]): List[t] =
      (xs, ys) match {
        case (Nil, _) => {
          print(xs, ys)
          ys
        }
        case (_, Nil) => xs
        case (x::xs1, y::ys1) =>
          if(less(x,y)) x::merge(xs1,ys)
          else y::merge(xs,ys1)
      }
    val n = xs.length / 2
    if(n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
}
