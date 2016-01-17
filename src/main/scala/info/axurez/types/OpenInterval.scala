package info.axurez.types


/**
 * Created by zhenghu on 2016/1/11.
 */
class OpenInterval(cLowerBound: ExtendedReals, cUpperBound: ExtendedReals) extends OpenSet {
  def lowerBound = cLowerBound

  def upperBound = cUpperBound

  def this(a: Float, b: Float) = this(new Reals(a), new Reals(b))

  def this(a: NegativeInfinity, b: Float) = this(a, new Reals(b))

  def this(a: Float, b: PositiveInfinity) = this(new Reals(a), b)

  require(lowerBound <= upperBound, "The interval must be valid!")

  override def toString(): String = {
    return "(" + lowerBound.toString + ", " + upperBound.toString + ")"
  }

  def intersectionWith(set: OpenInterval): OpenInterval = {
    val newLowerBound = if (this.lowerBound < set.lowerBound) {
      set.lowerBound
    } else {
      lowerBound
    }

    val newUpperBound = if (this.upperBound > set.upperBound) {
      set.upperBound
    } else {
      upperBound
    }

    new OpenInterval(newLowerBound, newUpperBound)
  }

  def intersectionWith(set: OpenSet): OpenSet = set match {
    case set: OpenInterval => intersectionWith(set)
    case _ => set // TODO: get the right result
  }
}


trait OpenSet {
  def intersectionWith(set: OpenSet): OpenSet
}


object RealLine extends RealLine {

}

case class RealLine extends OpenInterval(NegativeInfinity, PositiveInfinity) with OpenSet {
  override def intersectionWith(set: OpenSet): OpenSet = set
}
