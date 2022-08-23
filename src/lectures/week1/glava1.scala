package lectures.week1

import java.math.BigInteger
import scala.language.postfixOps

object glava1 extends App {
  var capital = Map("US" -> "Wasingtonn", "France" -> "Paris")
  capital += ("Japan" -> "Tokyo")
  println(capital("France"))

  def factorial(x: BigInt): BigInt = {
    if (x == 0) 1 else x * factorial(x - 1)
  }

  println(factorial(19))

  //  def factorial1(x: BigInteger): BigInteger = {
  //    if (x == BigInteger.ZERO)
  //      BigInteger.ONE
  //    else
  //      x.multiply(factorial(x.subtract(BigInteger.TEN)))
  //  }
  //
  //  println(factorial1(10))

  //  val xs = 1 to 3
  //  val it = xs.iterator
  //  eventually { it.next() shouldBe 3}

  val name = "How are to"

  val nameHasUpperCase = name.exists(_.isUpper)
  println(nameHasUpperCase)

  val mas: String = "Hello"
  println(mas)

  var msg = "Hi"
  msg = "By"

  def max(x: Int, y: Int): Int = {
    if (x > y) x
    else y
  }

  println(max(3, 5))

  def space() = println("Space")

  println(space())

  var line = "scala is fun"
  var i = 0
  while (i < line.length) {
    print(line(i))
    i += 1
  }
  println()


  i = 0
  while (i < line.length) {
    if (i != 0) print(" ")
    print(line(i))
    i += 1
  }
  println()

  line.foreach(symb => print(symb))
  println()

  line.foreach(print)
  println()

  for (symb <- line) {
    print(symb)
  }

  println()


}
