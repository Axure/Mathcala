package info.axurez.types

import org.scalatest._

/**
 * Created by zhenghu on 2016/1/11.
 */
object TypeTest extends FlatSpec with Matchers {
  def main(args: Array[String]) {

    "The 'greater than' operator" should "function properly" in {
      val A = new PositiveInfinity
      val B = new NegativeInfinity
      val C = new Reals(3)

      A > B should be true
      B > A should be false
      A > C should be true
      C > A should be false
      B > C should be false
      C > B should be true

      println(A > B)
      println(B > A)
      println(A > C)
      println(C > A)
      println(B > C)
      println(C > B)
    }

  }
}
