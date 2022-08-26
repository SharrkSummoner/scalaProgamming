package week2

object abject extends App {
  object Number {
    val Pi = 3.14
  }

  println(Number.Pi)

  class MyString(val str: String) {
    private var extra = "extraData"

    def getString: String = str + extra
  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString.apply("Hello", "world").getString)
  println(MyString.apply("wlcome").getString)

  // Beautiful case

  class MyStringB(val str: String) {
    private var extra = "extraData"

    def getString: String = str + extra
  }

  object MyStringB {
    def apply(base: String, extras: String): MyStringB = {
      val s = new MyStringB(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyStringB(base)
  }

  println(MyStringB.apply("hello", "world").getString)
  println(MyStringB.apply("welcome").getString)

  class Numbers(val num: Int)

  object Numbers {
    val Pi = 3.14

    def newNum(x: Numbers, y :Numbers): Numbers = new Numbers(x.num  + y.num)
  }

  val numA = new Numbers(1)
  val numB = new Numbers(2)

  val numC = Numbers.newNum(numA, numB)

  println(numA.num)
  println(numB.num)
  println(numB.num)

  // New numbers

  class Number1(val num: Int)

  object Number1 {
    val Pi = 3.14

    def apply(x: Number1, y: Number1): Number1 = new Number1(x.num + y.num)
  }

  val numA1 = new Number1(1)
  val numB1 = new Number1(2)

  val numC1 = Number1(numA1, numB1) // применяем apply

  println(numA1.num) // 1
  println(numB1.num) // 2
  println(numC1.num) // 3

}
