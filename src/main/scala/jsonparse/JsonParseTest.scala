package jsonparse

import com.twitter.finatra.httpclient.RequestBuilder
import com.twitter.finatra.json.FinatraObjectMapper
import org.json4s._
import org.json4s.native.JsonMethods._

object JsonParseTest {

  def main(args: Array[String]): Unit = {

    val mapper = FinatraObjectMapper.create()

    lazy val localClient = UnicornHttpClient.build("127.0.0.1", 8080, false, mapper)
    val finagleJson = localClient.executeJson[Map[String, Any]](RequestBuilder.get("/metrics"))

    var retMap: Map[String, Any] = Map()
    for {
      ss <- finagleJson
    } yield {
      ss.map(s => {
        retMap += (s._1.replaceAll("(\\/|:|\\.)", "_") -> s._2)
      })
      val aa = retMap.mkString("\n").replaceAll("-> ", "")

      println(aa)

      val a = ss.foldLeft(new StringBuilder){ (sb, s) => {
        sb append s
      } }.toString
      println(a)
      println(ss)
    }

    Thread.sleep(1000)
    println("END")

  }

  def jsonStrToMap(jsonStr: String): Map[String, Any] = {
    implicit val formats = org.json4s.DefaultFormats

    parse(jsonStr).extract[Map[String, Any]]
  }
}
