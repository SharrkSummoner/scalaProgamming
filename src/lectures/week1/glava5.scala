package lectures.week1

import scala.language.postfixOps

object glava5 extends App {
  val hex: Int = 0x5
  val hex2: Int = 0x00FF
  val magic = 0xcafebabe
  val dec1 = 31
  val dec2 = 255
  val dec3 = 20
  val prog = 0XCAFEBABEL
  val tower = 35L
  val of = 31l
  val little: Short = 367
  val litter: Byte = 38
  val big = 1.12345
  val bigger = 1.2345e1
  val biggerStill = 123E45
  val lit = 1.2345F
  val littleBigger = 3e5f
  val anotherDouble = 3e5
  val yetAnother = 3e5D


  println(s"$hex $hex2 $magic $dec1 $dec2 $dec3 $prog $tower $of $little $litter $big $bigger $biggerStill $lit $littleBigger $anotherDouble $yetAnother")

  // symbol

  val a = 'A'
  val d = '\u0041'
  val f = '\u0044'
  val backslash = '\\'

  println(s"$a $d $f $backslash")

  // line

  val hello = "hello"
  val escapes = "\\\"\'"

  println(s"$hello $escapes")
  println("""Welcome to Ultamix 3000. Type "HELP" for help.""")
  println(
    """
      |Welcome to Ultamix 3000.
      |Type "HELP" for help.
      |""".stripMargin)

  // Boolean

  val bool = true
  val fool = false

  // Interpolation

  val name = "reader"
  println(s"Hello, $name!")

  println(s"The answer is ${6 * 7}")

  println(raw"No\\\\escape!")

  val pi = "Pi"
  println(f"$pi is approximately ${math.Pi}%.8f")

  // all operators is a methods

  val num = 1 + 2 // 1.+(2)
  val sumMore = 1.+(2)
  val longSum = 1 + 2L
  val s = "Hello"

  println(s"$num $sumMore $longSum")

  println(s"${s indexOf 'o'}")
  println(s"${s indexOf ('o', 5)}")

  println(math.IEEEremainder(11.0, 4.0))

  val neg = 1 + -3
  val y = +3
  println(s"$neg $y ${-neg}")

  // relationships

  println(1 > 2)
  println(1 < 2)
  println(1.0 <= 1.0)
  println(3.5f >= 3.6f)
  println('a' >= 'A')

  val untrue = !true
  val toBe = true
  val question = toBe || !toBe
  val paradox = toBe && !toBe

  println(s"$untrue $toBe $question $paradox")

  def salt() = { println("salt"); false}
  def pepper() = { println("pepper"); true}

  println(pepper() && salt())
  println(salt() && pepper())

  // bitwise operation

  println(1 & 2)
  println(1 | 2)
  println(1 ^ 3)
  println(~1)

  println(-1 >> 31)
  println(-1 >>> 31)
  println(1 << 2)

  // the same contents of the objects

  println(1 == 2)
  println(1 != 2)
  println(2 == 2)

  println(List(1, 2, 3) == List(1, 2, 3))
  println(List(1, 2, 3) == List(4, 5, 6))

  println(1 == 1.0)

  println(List(1, 2, 3) == null)
  println(null == List(1, 2, 3))

  println(("he" + "llo") == "hello")

  // operator precedence

  println(2 << 2 + 2)
  println(2 + 2 << 2)


}
