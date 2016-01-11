package info.axurez.types

/**
 * Created by zhenghu on 2016/1/11.
 */
class Interval(lowerBound: ExtendedReals, upperBound: ExtendedReals) {
  override def toString(): String = {
    return "[" + lowerBound.toString + ", " + upperBound.toString + "]"
  }
}

object RealLine extends Interval(NegativeInfinity, PositiveInfinity) {

}
