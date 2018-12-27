package patternmatching

object PatternMatchingTest {
  def main(args:Array[String]): Unit = {
    println("PatternMathing Test")
    println("Test: " + matchingTest(2))

    println("Test2: " + matchTest(1))
    println("Test2: " + matchTest(2))

    val alice = new Person("alice", 38)
    val bob = new Person("bob", 40)
    for(person <- List(alice, bob)) {
      person match {
        case Person("alice", 38) => println("AliceClass")
        case Person("bob", 40) => println("BobClass")
      }
    }
  }

  case class Person(name:String, age:Int)

  def matchingTest(x:Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def matchTest(x: Any):Any = x match {
    case 1 => "one"
    case "two" => 2
    case y:Int => "Scala.int"
    case _ => "many"
  }
}
