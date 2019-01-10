package typetest

object TypeTest {

  //암묵적으로 이 함수가 호출될 필요가 있을때 호출된다 단 이 함수가 윗부분에 위치해야한다.
  implicit def strToInt(x: String) = x.toInt

  def main(args: Array[String]): Unit = {
    foo(List("one", "two")) // Hey, this list is full of strings
    foo(List(1, 2)) // Non-stringy list
    foo(List("one", 2)) // Non-stringy list

    val y: Int = "123"
    val wmax = math.max("123", 111)
    println(wmax)

    println(List(1,2,3,4).min(new Ordering[Int] { def compare(a: Int, b: Int) = b compare a }))
    println(List(1,2,3,4).min)

    println(List(new MyContainer, new MyContainer, new MyContainer).min)

    println("A="+new MakeFoo[String].make)

    val getTweet: (Bird => String) = (b:Animal) => b.sound+"A"
    println("getTweet: " + getTweet(new Bird()))
    println("getTweet: " + getTweet(new Chicken()))

    //T type을 animal하위타입으로 지정해서 sound를 가져올수 있게 한다.
    def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
    println(biophony(Seq(new Chicken, new Bird)))

    println(meth(List("string")))
    println(meth(List(new Bar)))
  }

  //아래와 같음
//  def foo[T](x: List[T])(implicit m: Manifest[T]) = {
//    if (m <:< manifest[String])
//      println("Hey, this list is full of strings")
//    else
//      println("Non-stringy list")
//  }
  def foo[T: Manifest](x: List[T]) = {
    if (manifest[T] <:< manifest[String])
      println("Hey, this list is full of strings")
    else
      println("Non-stringy list")
  }

//  def meth[A](xs: List[A]) = xs match {
//    case _: List[String] => "list of strings"
//    case _: List[Foo] => "list of foos"
//  }
  import scala.reflect.runtime.universe._
  def meth[A : TypeTag](xs: List[A]) = typeOf[A] match {
    case t if t =:= typeOf[String] => "list of strings"
    case t if t <:< typeOf[Foo] => "list of foos"
  }
}

class Foo
class Bar extends Foo

class Animal { val sound = "rustle" }
class Bird extends Animal { override val sound = "puuk" }
class Chicken extends Bird { override val sound = "cock" }

class MakeFoo[A](implicit manifest: Manifest[A]) { def make: A = manifest.erasure.newInstance.asInstanceOf[A] }

class MyContainer extends Container[MyContainer] {
  def compare(that: MyContainer) = 0
}

trait Container[A <: Container[A]] extends Ordered[A]

trait LowPriorityOrderingImplicits {
  implicit def ordered[A <: Ordered[A]]: Ordering[A] = new Ordering[A] {
    def compare(x: A, y: A) = x.compare(y)
  }
}