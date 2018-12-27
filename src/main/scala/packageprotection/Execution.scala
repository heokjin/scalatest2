package packageprotection
  package society
    class Execution {
      private[society]  var workDetail = null
      private[packageprotection] var friends= null
      private[this] var secrets = null

      def help(another : Execution): Unit = {
        println(another.workDetail)
        println(another.friends)
        //println(another.secrets)
        /***
        Variable secrets will be accessible only on the
        implicit object within instance methods (this).
        ***/
      }
}
