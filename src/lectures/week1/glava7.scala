package lectures.week1

import java.io.{File, FileNotFoundException, FileReader}
import java.util.regex.Pattern
import scala.annotation.tailrec
import scala.language.postfixOps
import java.io.IOException
import java.net.URL
import java.net.MalformedURLException

object glava7 extends App {

  // if

  var filename = "default.txt"
  if (filename.isEmpty) filename = "empty"
  println(filename)

  val filename2 = if (filename.nonEmpty) "nonempty" else "default.txt"
  println(if (filename.nonEmpty) "nonempty" else "default.txt")

  // while

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  def greet(): Unit = println("hi")

  () == greet()

  @tailrec
  def gcd(x: Long, y: Long): Long = if (y == 0) x else gcd(y, x % y)

  // for

  val filesHere = (new File(".")).listFiles()
  for (file <- filesHere) println(file)

  for (i <- 1 to 4) print(i)
  for (i <- 1 until 4) print(i)
  for (i <- 0 until filesHere.length) println(filesHere(i))

  // filters

  for (file <- filesHere if file.getName.endsWith(".scala")) println(file)

  for (file <- filesHere) if (file.getName.endsWith(".scala")) println(file)

  for (
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".scala")
  ) println(file)

  // iteration

  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String): Unit =
    for (
      file <- filesHere
      if file.getName.endsWith(".scala");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(s"$file: ${line.trim}")

  grep(".*gcd.*")

  // intermediate variables

  def grap(pattern: String): Unit =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(s"$file: $trimmed")

  grap(".*gcd.*")

  // new collection

  def scalaFiles = {
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file
  }

  println(scalaFiles.mkString("Array(", ", ", ")"))

  var forLineLengths: Unit = {
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length

    println(forLineLengths)
  }

  // exceptions

  val n = 10

  val half = {
    if (n % 2 == 0) n / 2
    else throw new RuntimeException("n must be even")
  }

  println(half)

  // try-catch

  try {
    val f = new FileReader("input.txt")
  } catch {
    case ex: FileNotFoundException =>
    case ex: IOException =>
  }

  // finally

  //  val file = new FileReader("input.txt")
  //  try {
  //  } finally {
  //    file.close()
  //  }

  // issuing values

  def urlFor(path: String) = {

    try {
      new URL(path)
    } catch {
      case e: MalformedURLException => new URL("http://www.scala-lang.org")
    }
  }

  println(urlFor("meow"))

  def f(): Int = try return 1 finally return 2

  def g(): Int = try 1 finally 2

  // Mapping expressions
  val line = "salt"
  val firstArg = if (line.length > 0) line(0) else ""

  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }

  val firstArg2 = if (!line.isEmpty) line(0) else ""
  val friend =
    firstArg2 match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
  println(friend)

  // no break no continue

  var i = 0
  var foundIt = false

  //  while (i < args.length && !foundIt) {
  //    if (!args(i).startsWith("-")) {
  //      if (args(i).endsWith(".scala"))
  //        foundIt = true
  //    }
  //    i += 1
  //  }

  //  @tailrec
  //  def searchFrom(i: Int): Int = {
  //    if (i >= args.length) - 1
  //    else if (args(i).startsWith("-")) searchFrom(i + 1)
  //    else if (args(i).endsWith(".scala")) i
  //    else searchFrom(i + 1)
  //  }
  //
  //  println(searchFrom(0))

  // Variable scope

  def printMultiTable(): Unit = {
    var i = 1
    while (i <= 10) {
      var j = 1
      while (j <= 10) {
        val prod = (i * j).toString

        var k = prod.length

        while (k > 4) {
          print(" ")
          k += 1
        }

        print(prod)
        j += 1
      }

      println()
      i += 1
    }
  }

  printMultiTable()

  val a = 1;
  {
    val a = 2
    println(a)
  }
  println(a)

  // Refactoring Code Written in Imperative Style

  // Возвращение строчки в виде последовательности
  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }

  // Возвращение строки в виде строкового значения
  def makeRow(row: Int) = makeRowSeq(row).mkString
  // Возвращение таблицы в виде строковых значений, по одному значению

  // на каждую строку
  def multiTable() = {
    val tableSeq = // последовательность из строк таблицы
    for (row <- 1 to 10)
      yield makeRow(row)
    tableSeq.mkString("\n")
  }

  multiTable()


}
