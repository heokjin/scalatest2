package exceptionhandling

import java.io.{FileNotFoundException, FileReader, IOException}

object ExceptionHandling {
  def main(args: Array[String]): Unit = {
    println("Exception handling")
    try {
      val f = new FileReader("a.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("File missing!")
        ex.printStackTrace()
      }

      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Fin.")
    }

  }
}
