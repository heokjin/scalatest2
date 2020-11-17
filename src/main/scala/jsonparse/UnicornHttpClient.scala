package jsonparse

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finagle.{Http, Service}
import com.twitter.finatra.httpclient.HttpClient
import com.twitter.finatra.httpclient.modules.HttpClientModule
import com.twitter.finatra.json.FinatraObjectMapper

/**
  * Created by hyosik on 2017. 6. 5..
  */
object UnicornHttpClient {
  def build(host: String, port: Int = 80, ssl: Boolean, mapper: FinatraObjectMapper) = {
    val httpClientModule = new HttpClientModule {
      override def dest = s"$host:$port"
      override def defaultHeaders: Map[String, String] = Map("Host" -> host)
      def buildHttpClient(mapper: FinatraObjectMapper,
                          httpService: Service[Request, Response]): HttpClient = {
        new HttpClient(
          hostname = hostname,
          httpService = httpService,
          retryPolicy = retryPolicy,
          defaultHeaders = defaultHeaders,
          mapper = mapper
        )
      }
    }

    val httpClient = ssl match {
      case false => Http.client.newClient(s"$host:$port").toService
      case true => Http.client.withTls(host).newClient(s"$host:$port").toService
    }

    httpClientModule.buildHttpClient(mapper, httpClient)
  }
}
