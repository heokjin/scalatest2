package colletion

import colletion.ProductCode.ProductCode
import com.twitter.util.Future

object jointest {

  def main(args: Array[String]): Unit = {
    println("join test")
  }

  def active(userId: String): Future[Seq[ActiveCall]] = {
    Future.collect(Seq())
  }

  case class ActiveCall(productCode: ProductCode, callIds: Array[String])
}
