package info.axurez.types

/**
 * Created by zhenghu on 2016/1/11.
 */

abstract class ExtendedReals {
  def >(that: ExtendedReals): Boolean
}

case class Reals(value: Double) extends ExtendedReals {
  def >(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => this.value > t.value
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }
  }
}

case class PositiveInfinity() extends ExtendedReals {
  def >(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => true
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }
  }
}

case class NegativeInfinity() extends ExtendedReals {
  def >(that: ExtendedReals): Boolean = {
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => false
    }
  }
}