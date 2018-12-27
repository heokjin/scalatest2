package split

object SplitTest {
  def main(args: Array[String]): Unit = {
    val line = "brick,cement,concrete"

    // Split on each comma.
    val result = line.split(',')

    // Array length.
    println(result.length)

    // Print all elements in array.
    for (v <- result) {
      println(v)
    }
  }
}
