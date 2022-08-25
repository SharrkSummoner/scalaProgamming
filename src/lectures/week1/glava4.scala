package lectures.week1

object glava4 extends App {

  class Checksum {
    var sum = 0
  }

  val acc = new Checksum
  val csa = new Checksum

  acc.sum = 3

  println(acc.sum)
  println(csa.sum)

  class ChecksumPrivate {
    private var sum = 0

    def add(b: Byte): Unit = {
      sum += b
    }

    def checksum(): Int = {
      return ~(sum & 0xFF) + 1
    }
  }

  class ChecksumRework {
    private var sum = 0

    def add(b: Byte) = sum += b

    def checksum() = ~(sum & 0xFF) + 1
  }

  class ChecksumFinal {
    private var sum = 0

    def add(b: Byte): Unit = {
      sum += b
    }

    def checksum(): Int = ~(sum & 0xFF) + 1
  }

  val s = "hello";
  println(s)

  if (1 < 2)
    println("too small")
  else
    println("ok")


}
