package info.axurez.types

import com.sun.javaws.exceptions.InvalidArgumentException
import org.scalatest.FlatSpec
import org.scalatest._

object IntervalTest extends FlatSpec with Matchers {
  def main(args: Array[String]): Unit = {
    println(RealLine)

    val A = new Interval(3, 5)
    val B = new Interval(3, PositiveInfinity)
    val C = new Interval(NegativeInfinity, 5)
    println(A)
    println(B)
    println(C)

    var D: Interval = null
    try {
      D = new Interval(PositiveInfinity, NegativeInfinity)
    } catch {
      case e: IllegalArgumentException => println("Expected exception: " + e)
      case _: Throwable => println("Generic exception!")
    } finally {
      println(D)
    }

  }
}
