package lectures.week1

import scala.compiletime.ops
import scala.compiletime.ops.int

object Functions extends App {
  def aPerson(name: String, surname: String): String = {
    s"$name $surname"
  }

  println(aPerson("John", "Smith"))

  def aPerson2(name: String, surname: String): Unit = println(s"$name $surname")

  aPerson2("John" , "Smith")

  def aParameterlessFunction(): Unit = println("Function with no parameters")

  aParameterlessFunction()

  def aFunctionWithDefaultParameter(x: Int, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }

  println(aFunctionWithDefaultParameter(1)) // выводит x = 1 and y = Default Parameter

  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def someFunc(): Int = 2 * someFunc() + 1

  def callSomeFunc(x: Int, y: => Int) = println(x)

  callSomeFunc(1, someFunc())

  def aBossFunction(): String = {
    def aHelperFunction(): String = "Im hero"

    aHelperFunction()
  }
  println(aBossFunction())

  // исправьте код
  def aCondition(): Boolean = if (1 > 2) true else false

  def someFunnc(x: Int, y: Int): Unit = {
    if (aCondition()) x * 3
    else multiply(y)
  }

  def multiply(i: Int): Int = {
    val y = i + 1
    y
  }
}
