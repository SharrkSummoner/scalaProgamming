package rationals

object rationalNumbers extends App {
  class Rational(n: Int, d: Int) {

    require(d != 0)

    private val g = gcd(n.abs, d.abs)

    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)

    def + (that: Rational): Rational = {
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    }

    def + (i: Int): Rational = new Rational(numer + i * denom, denom)

    def - (that: Rational): Rational = {
      new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    }

    def - (i:Int): Rational = new Rational(numer - i * denom, denom)

    def * (that: Rational): Rational = {
      new Rational(numer * that.numer, denom * that.denom)
    }

    def *(i: Int): Rational = new Rational(numer * i, denom)

    def / (that: Rational): Rational = {
      new Rational(numer * that.denom, denom * that.numer)
    }

    def / (i: Int): Rational = new Rational(numer, denom * i)

    override def toString: String = numer + "/" + denom

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    def lessThan(that: Rational): Boolean = {
      this.numer * that.denom < that.numer * this.denom
    }

    def max(that: Rational): Rational = {
      if (lessThan(that)) that else this
    }
  }

  val x = new Rational(1, 2)
  val y = new Rational(2, 3)

  println()
  println(x * (x + y))


}
