package classpkg

class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
    println("Point x Location : " + x)
    println("Point y location : " + y)
  }
}

class Location(override val xc: Int, override val yc: Int, val zc: Int) extends Point(xc, yc){
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    x = x + dx
    y = y + dy
    z = z + dz
    println("Point x Location : " + x)
    println("Point y Location : " + y)
    println("Point z Location : " + z)
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    val pt = new Point(1,2)
    pt.move(1,2)

    val loc = new Location(1,2,3)
    loc.move(1,2,3)
  }
}
