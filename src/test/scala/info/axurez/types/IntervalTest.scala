package info.axurez.types

import com.sun.javaws.exceptions.InvalidArgumentException
import org.scalatest.FlatSpec
import org.scalatest._

object IntervalTest extends FlatSpec with Matchers {
  def main(args: Array[String]): Unit = {
    println(RealLine)

    val A = new OpenInterval(3, 5)
    val B = new OpenInterval(3, PositiveInfinity)
    val C = new OpenInterval(NegativeInfinity, 5)
    println(A)
    println(B)
    println(C)

    var D: OpenInterval = null
    try {
      D = new OpenInterval(PositiveInfinity, NegativeInfinity)
    } catch {
      case e: IllegalArgumentException => println("Expected exception: " + e)
      case _: Throwable => println("Generic exception!")
    } finally {
      println(D)
    }

  }
}
