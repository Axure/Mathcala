package info.axurez.types

/**
 * Created by zhenghu on 2016/1/11.
 */

abstract class ExtendedReals {
  def >(that: ExtendedReals): Boolean
  def ==(that: ExtendedReals): Boolean
  def <(that: ExtendedReals): Boolean
  def <=(that: ExtendedReals): Boolean = {
    this < that || this == that
  }
  def >=(that: ExtendedReals): Boolean = {
    this > that || this == that
  }
  override def toString(): String
}

case class Reals(value: Double) extends ExtendedReals {

  def >(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => this.value > t.value
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }
  }

  def <(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => this.value < t.value
      case t: PositiveInfinity => true
      case t: NegativeInfinity => false
    }
  }

  def ==(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => this.value == t.value
      case t: PositiveInfinity => false
      case t: NegativeInfinity => false
    }
  }

  override def toString(): String = this.value.toString
}

case class PositiveInfinity() extends ExtendedReals {
  def >(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => true
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }
  }

  def <(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => false
    }
  }

  def ==(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => false
      case t: PositiveInfinity => true
      case t: NegativeInfinity => false
    }
  }

  override def toString(): String = "+inf"
}

case class NegativeInfinity() extends ExtendedReals {
  def >(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => false
    }
  }

  def <(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => true
      case t: PositiveInfinity => true
      case t: NegativeInfinity => false
    }
  }

  def ==(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }
  }

  override def toString(): String = "-inf"
}

object PositiveInfinity extends PositiveInfinity {

}

object NegativeInfinity extends NegativeInfinity {

}
