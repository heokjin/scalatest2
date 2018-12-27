package kakao

object Coding3 {
  def main(args: Array[String]): Unit = {
    val cities: List[String] = List("Jeju", "Pangyo", "Seoul", "NewYork", "LA")
    val cacheSize = 0

    if (!(cacheSize>=0 && cacheSize<=30)) {
      println("Try")
      return
    }

    var opCount: Int = 5
    var cache = new LRUCache[String, String](cacheSize)
    cities.foreach(s => {
      val l = s.toLowerCase()
      if(cache.usedEntries() > 0) {
        if (cache.get(l) == null) {
          opCount += 5
        } else {
          opCount += 1
        }
      }
      cache.put(l,l)
    })

    println("OpCount: " + opCount)
  }
}
