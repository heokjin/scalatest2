package traits

trait Equal {
  def isEqual(x:Any): Boolean
  def isNotEqual(x:Any): Boolean = !isEqual(x)
}
class Point(xc:Int, xy:Int) extends Equal {
  val x:Int = xc
  val y:Int = xy

  def isEqual(obj:Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y //여기서 y는 p1의 y이다.
}

//Universal Traits
trait Printable extends Any {
  def print():Unit = println(this)
}
/**
이렇게 괜찮은 AnyVal을 상속받은 값 클래스는 제약이 당연히 있다.
- 단일 매개변수가 하나의 public val인 주요 생성자가 단 하나가 있어야 한다.
- 생성자의 매개변수는 값 클래스가 될 수 없다.
- val 또는 var는 값 클래스 내부에서 사용할 수 없다.
  */
class Wrapper(val underlaying:Int) extends AnyVal with Printable

object TraitsTest {
  def main(args: Array[String]): Unit = {
    println("Trait Test")

    val p1 = new Point(2,3)
    val p2 = new Point(1,1)
    val p3 = new Point(3,1)

    println(p1.isEqual(p1))
    println(p1.isNotEqual(p2))
    println(p1.isEqual(3))
    println(p1.isEqual(p3))

    val w = new Wrapper(3)
    w.print()
  }
}
