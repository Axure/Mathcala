package info.axurez.types

import org.scalatest._

/**
 * Created by zhenghu on 2016/1/11.
 */
object RealTest extends FlatSpec with Matchers {
  def main(args: Array[String]) {

//    "The 'greater than' operator" should "function properly" in {
      val A = PositiveInfinity
      val B = NegativeInfinity
      val C = new Reals(3)

      (A > B) should equal  (true)
      B > A should equal  (false)
      A > C should equal  (true)
      C > A should equal  (false)
      B > C should equal  (false)
      C > B should equal  (true)

      println(A > B)
      println(B > A)
      println(A > C)
      println(C > A)
      println(B > C)
      println(C > B)
//    }

    (A < B) should equal  (false)
    B < A should equal  (true)
    A < C should equal  (false)
    C < A should equal  (true)
    B < C should equal  (true)
    C < B should equal  (false)

    A == A should equal (true)
    A == B should equal (false)
    A == C should equal (false)
    B == B should equal (true)
    B == C should equal (false)
    C == C should equal (true)

    val D = new Reals(4)

    A >= D should equal (true)
    A >= B should equal (true)
    A >= C should equal (true)
    A >= A should equal (true)

    A <= D should equal (false)
    A <= B should equal (false)
    A <= C should equal (false)
    A <= A should equal (true)

  }
}
