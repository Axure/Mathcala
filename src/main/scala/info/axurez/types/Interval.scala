package info.axurez.types

/**
 * Created by zhenghu on 2016/1/11.
 */
class Interval(lowerBound: ExtendedReals, upperBound: ExtendedReals) {
  def this(a: Float, b: Float) = this(Reals(a), Reals(b))
  def this(a: NegativeInfinity, b: Float) = this(a, Reals(b))
  def this(a: Float, b: PositiveInfinity) = this(Reals(a), b)

  require(lowerBound <= upperBound, "The interval must be valid!")

  override def toString(): String = {
    return "[" + lowerBound.toString + ", " + upperBound.toString + "]"
  }
}

object RealLine extends Interval(NegativeInfinity, PositiveInfinity) {

}
