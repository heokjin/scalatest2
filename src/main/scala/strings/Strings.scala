package strings

object Strings {
  def main(args: Array[String]): Unit = {
    val s1: String = "1.0.11"
    val s2: String = "4.1.211"
    if(s1 > s2) {
      println("A")
    } else {
      println("B")
    }

    println("Strings test")

    println("123".toLong%10)

    val str1 = "Heokjin"
    println(str1.length)
    println(str1.concat(" Hello!"))

    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "Hello, Scala!"
    var fs = printf("The value of the float variable is " + "%f, while the value of the integer " + "variable is %d, and the string" + "is %s", floatVar, intVar, stringVar);
    println(fs)

    val name = "Heokjin"
    println(s"Hello $name!~")
    println(s"1+1 = ${1+1}")

    val height = 1.9d
    val name2 = "Heokjin"
    println(f"$name2%s have $height%2.2f money") //formater

    println(raw"Heokjin is a chllenage\n man always")
  }
}
