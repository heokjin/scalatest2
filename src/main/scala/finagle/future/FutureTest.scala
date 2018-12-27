package finagle.future

import com.twitter.util.{Await, Future}

object FutureTest {

  def main(args: Array[String]): Unit = {
    val locations = Seq("1", "2", "3")
    println(locations.length)

    var seqResults: Seq[Future[Array[WcodeResult]]] = Seq()
    locations.grouped(2).foreach(groups => {
      println("Group:" + groups)
    })

    seqResults = seqResults :+ wcodeResults1(Seq("mock"))
    seqResults = seqResults :+ wcodeResults2(Seq("mock"))
    val f = Future.collect(seqResults)
    val aw = f.map(r => r.flatten.toArray)
    println("AW: " + aw)
    val re = Await.result(aw)
    println("R1", re)
    println("R2", re(1))


    //loop 상태에서 await를 사용하면 절대 안됨!
//    val re = Await.result(f)
//    println("R1", re)
//    println("R2", re(0))
//
//    val fl = re.flatten.toArray
//    println(fl)
//    println(fl.length)
//    val fu = (Future.value(fl))

    //이코드를 써야함
//    def collectGetWorldRegionCodes(locations: Seq[String]): Future[Array[WcodeResult]] = {
//      Future.collect(locations.grouped(LIMIT_PARAM_COUNT_GET_WORLD_REGION_CODE).
//        map(l => getWorldRegionCodes(l)).toArray).map(aw => aw.flatten.toArray)
//    }

  }

  def wcodeResults1(locations: Seq[String]): Future[Array[WcodeResult]] = {
    Thread.sleep(1500)
    val w1 = WcodeResult.apply("Viewname1", "Code1", "CodeDesc1", "ClassCode1", "ClassCodeDesd1", "IsonNum1", "IsoName1", "IsoAlpha1", "IsoAlpha1")
    val w2 = WcodeResult.apply("Viewname2", "Code2", "CodeDesc2", "ClassCode2", "ClassCodeDesd2", "IsonNum2", "IsoName2", "IsoAlpha2", "IsoAlpha2")
    val r = Array(w1, w2)
    Future.value(r)
  }

  def wcodeResults2(locations: Seq[String]): Future[Array[WcodeResult]] = {
    Thread.sleep(1000)
    val w1 = WcodeResult.apply("Viewname3", "Code3", "CodeDesc3", "ClassCode3", "ClassCodeDesd3", "IsonNum3", "IsoName3", "IsoAlpha3", "IsoAlpha3")
    val w2 = WcodeResult.apply("Viewname4", "Code4", "CodeDesc4", "ClassCode4", "ClassCodeDesd4", "IsonNum4", "IsoName4", "IsoAlpha4", "IsoAlpha4")
    val r = Array(w1, w2)
    Future.value(r)
  }

  case class WcodeResult(viewname: String,
                         code: String,
                         codedesc: String,
                         classcode: String,
                         classcodedesc: String,
                         isonum: String,
                         isoname: String,
                         isoalpha2: String,
                         isoalpha3: String)

}
