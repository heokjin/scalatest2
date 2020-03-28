name := "scalatest2"

version := "0.1"

scalaVersion := "2.12.6"

lazy val versions = new {
  val finagle = "20.1.0"
  val guice = "4.0"
  val logback = "1.1.7"
  val mockito = "1.9.5"
  val scalatest = "3.0.0"
  val scalacheck = "1.13.4"
  val specs2 = "2.4.17"
  val typesafeConfig = "1.3.2"
  val zipkin = "2.1.5"
  val sentry = "1.6.4"
  val newrelic = "5.0.0"
  val jacksonDataBind = "2.9.10.3"
}

libraryDependencies += "com.twitter" %% "finagle-http" % "18.11.0"
libraryDependencies += "commons-io" % "commons-io" % "2.6"
libraryDependencies += "commons-codec" % "commons-codec" % "1.11"
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.3.2"
libraryDependencies += "commons-codec" % "commons-codec" % "1.11"
libraryDependencies += "joda-time" % "joda-time" % "2.9.4"
libraryDependencies += "com.twitter" %% "finatra-http" % versions.finagle,
libraryDependencies += "com.twitter" %% "finatra-httpclient" % versions.finagle,



