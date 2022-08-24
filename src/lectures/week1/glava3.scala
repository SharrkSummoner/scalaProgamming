package lectures.week1

import java.math.BigInteger

object glava3 extends App {
  var big = new BigInteger("12345")

  val greetStrings = new Array[String](3)

  greetStrings(0) = "Hello"
  greetStrings(1) = ", "
  greetStrings(2) = "world!\n"

  for (i <- 0 to 2) {
    print(greetStrings(i))
  }

  val numNames = Array("zero", "one", "two")

  val oneTwoThree = List(1, 2, 3)

  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour
  println("sd" + oneTwo + " and " + threeFour + " were not mutated.")
  println("Thus, " + oneTwoThreeFour + " is a new list.")

  val twoThree = List(2, 3)
  val oneTwoThree1 = 1 :: twoThree
  println(oneTwoThree1)

  val newOneTwoThree = 1 :: 2 :: 3 :: Nil
  println(newOneTwoThree)

  val pair = (99, "Luft")
  println(pair._1)
  println(pair._2)

  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))

  import scala.collection.mutable
  val movieSet = mutable.Set("Hitch", "Poltergeist")
  movieSet += "SHrek"
  println(movieSet)

  import scala.collection.immutable.HashSet
  val hashSet = HashSet("Tomatoes", "Chiles")
  println(hashSet + "Coriander")

  import scala.collection.mutable
  val treasureMap = mutable.Map[Int, String]()
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  println(treasureMap(2))

  val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  println(romanNumeral(4))

  // 3 type of print array

  def printArgs(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  def printArgs2(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg)
  }

  def printArgs3(args: Array[String]): Unit = {
    args.foreach(println)
  }

  def formatArgs(args: Array[String]) = args.mkString("\n")

  val res = formatArgs(Array("zero", "one", "two"))
  assert(res == "zero\none\ntwo")
}
