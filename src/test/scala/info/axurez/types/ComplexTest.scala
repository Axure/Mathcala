package info.axurez.types

import org.scalatest._

/**
 * Created by zhenghu on 2016/1/11.
 */

object ComplexTest extends FlatSpec with Matchers {
  def main(args: Array[String]) {
    val A = new Complex(0, 5)
    val B = new Complex(3, 5)
    val C = new Complex(3, 0)
    val D = new ComplexInfinity
    val E = new PositiveInfinity

    println(A)
    println(B)
    println(C)
    println(D)
    println(E)

    println(D == E)
  }

}
