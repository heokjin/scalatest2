package book.spiral

import Element.elem

object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges: Int, direction: Int): Element = {
    if(nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges-1, (direction+3)%4)
      def verticalVar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if(direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if(direction == 1)
        (sp above space) beside (corner above verticalVar)
      else if(direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalVar above corner) beside (space above sp)
    }
  }
  def main(args: Array[String]): Unit = {
    val nSide = 6
    println(spiral(nSide, 0))
  }
}

abstract class Element {
  def contents: Array[String]
  def width: Int = if(height == 0) 0 else contents(0).length
  def height: Int = contents.length

  def above(that: Element): Element ={
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(for((line1, line2) <- this1.contents zip that1.contents) yield line1+line2)
  }
  def widen(w: Int): Element =
    if(w <= width) this
    else {
      val left = elem(' ', (w-width)/2, height)
      var right = elem(' ', w-width-left.width, height)
      left beside this beside right
    }
  def heighten(h: Int): Element =
    if(h <= height) this
    else {
      val top = elem(' ', width, ((h-height)/2))
      var bot = elem(' ', width, h-height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"
}

object Element {
  private class ArrayElement(val contents: Array[String]) extends Element

  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }
  private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)

  def main(args: Array[String]): Unit = {
    val b1 = new ArrayElement(Array("one"))
    val b2 = new ArrayElement(Array("one", "two"))
    println(b1 beside b2)

    val a1 = Array("A", "B")
    val a2 = Array("C", "D")
    val t = a1 ++ a2
    t.foreach(s => print(s))
    println()

    val c = for((l1, l2) <- a1 zip a2) yield l1+l2
    println(c)
    c.foreach(a => println(a))

    val d = Array.fill(30)("*")
    d.foreach(s => print(s))

    println()
    println(d)
    println(d mkString) //print to Array elements
  }
}
