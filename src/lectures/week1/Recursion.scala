package lectures.week1

import lectures.StringOperations.aString
import lectures.week1.Recursion.line

import scala.annotation.tailrec
import scala.compiletime.ops.string.Length
import scala.jdk.Accumulator

object Recursion extends App {
  var i = 0
  while (i < 3) {
    println("hello")
    i += 1
  }

  // Is a bad recursion
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(4))

  // Its a good (Tail Recursion)
  def tailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x < 1) accumulator
      else loop(x - 1, x * accumulator)
    }

    loop(n)
  }

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }

    loop(n)
  }

  println(repeatWord("hello", 3))

  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def loop(x: Int, accumulator: BigInt = 1): BigInt = {
      if (x < 1) accumulator
      else loop(x - 1, accumulator * 2)
    }

    loop(n)
  }

  def addNum(x: Int, y: Int, i: Int): Int = {
    @tailrec
    def loop(x: Int, y: Int, i: Int): Int = {
      if (x == (x + y * i)) x
      else loop(x + y, y, i - 1)
    }

    loop(x, y, i)
  }

  def countNum(x: Int): String = {
    @tailrec
    def loop(x: Int, old: Int): String = {
      if (x == 0) "is the result"
      else {
        print(s"$old ")
        loop(x / 10, old)
      }
    }

    loop(x, x)
  }

  println(countNum(addNum(1599, 2, 47)))

  val result = (10 + 1 * 5).toString

  @tailrec
  def go(n: Int): Unit =
    if (n == 0)
      println("is the result")
    else {
      print(result + " ")
      go(n - 1)
    }

  go(result.length)

  def aCondition(): Boolean = if (1 < 2) true else false

  def someFunnc(x: Int, y: Int): Int = {
    if (aCondition()) x * 2
    else x * 2
  }

  val line = " I l ike      Sc ala "

  def uTurn(line: String, start: Int, end: Int): Unit = {

    @tailrec
    def loop(trimLine: String, length: Int): Unit = {
      if (length == end - 1) print(trimLine.charAt(length))
      else {
        print(trimLine.charAt(length))
        loop(trimLine, length - 1)
      }
    }

    loop(line, start)
  }

  //println(line.substring(4, 11))
  def checkWord(line: String): Unit = {
    val trimLine = line.trim.replaceAll("\\s+", " ")

    var length = trimLine.length - 1

    @tailrec
    def loop(trimLine: String, start: Int, end: Int): Unit = {
      if (end == 0) {
        print(trimLine.substring(end, start))
      }
      else {
        if (trimLine.charAt(end).toString != " ") {
          loop(trimLine, start, end - 1)
        }
        else {
          print(trimLine.substring(end + 1, start) + " ")
          loop(trimLine, end, end - 1)
        }
      }
    }

    loop(trimLine, length + 1, length)
  }

  println(line.split("\\s+").toList.reverse.mkString("meow"))


}
