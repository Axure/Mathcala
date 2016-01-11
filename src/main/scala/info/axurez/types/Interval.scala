package info.axurez.types


/**
 * Created by zhenghu on 2016/1/11.
 */
class Interval(cLowerBound: ExtendedReals, cUpperBound: ExtendedReals) {
  def lowerBound = cLowerBound
  def upperBound = cUpperBound

  def this(a: Float, b: Float) = this(new Reals(a), new Reals(b))
  def this(a: NegativeInfinity, b: Float) = this(a, new Reals(b))
  def this(a: Float, b: PositiveInfinity) = this(new Reals(a), b)

  require(lowerBound <= upperBound, "The interval must be valid!")

  override def toString(): String = {
    return "[" + lowerBound.toString + ", " + upperBound.toString + "]"
  }
}

object RealLine extends Interval(NegativeInfinity, PositiveInfinity) {

}
