package innerclass

class Outer {
  class Super {
    protected def f(): Unit = {
      println("F")
    }
  }
  class Sub extends Super {
    f()
  }
  class Other {
   // (new Super).f() //Error
  }


  class Inner {
    private def f(): Unit = {
      println("f")
    }

    class InnerMost {
      f()
    }
  }
  //(new Inner).f() //Error


  class Outer2 {
    class Inner {
      def f() {println("F")}

      class InnerMost {
        f()
      }
    }
    (new Inner).f()
  }

}
