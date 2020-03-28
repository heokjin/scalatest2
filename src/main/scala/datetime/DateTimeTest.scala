package datetime


import java.util.Date

import org.joda.time.{DateTime, DateTimeZone}
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}



object DateTimeTest {

  def main(args: Array[String]): Unit = {
    println("DateTime")

//    val dateTime = new DateTime().withZone(DateTimeZone.forID("America/Los_Angeles"))
    val dateTime = new DateTime().withZone(DateTimeZone.forID("Asia/Seoul"))

    val d = new Date()
    println(d)


    val fare = 40700
    val maximum1 = fare + (fare * 0.1f).toInt
    println(maximum1)

    val fare2 = 44700
    println((fare2*0.7f).toInt)

    println(44700*0.7)
    println((1000.9999f).toInt)
    println((1000.9999f))
    println(1000.99999f)
  }

}
