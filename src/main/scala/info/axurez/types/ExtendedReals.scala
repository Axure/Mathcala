package info.axurez.types

/**
 * Created by zhenghu on 2016/1/11.
 */

abstract trait ExtendedReals extends ExtendedComplexes {
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

abstract trait RealInfinity extends ExtendedReals {}

class Reals(cValue: Double) extends Complex(cValue, 0) with ExtendedReals {
  def value = this.realPart

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

  override def ==(that: ExtendedComplexes): Boolean = {
    that match {
      case t: Complex => this.value == t.realPart && t.imaginaryPart == 0
      case ComplexInfinity => false
    }
  }

  override def toString(): String = this.value.toString
}

object PositiveInfinity extends PositiveInfinity {}
class PositiveInfinity extends ComplexInfinity with RealInfinity {
  def >(that: ExtendedReals): Boolean =
    that match {
      case t: Reals => true
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }


  def <(that: ExtendedReals): Boolean =
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => false
    }


  def ==(that: ExtendedReals): Boolean =
    that match {
      case t: Reals => false
      case t: PositiveInfinity => true
      case t: NegativeInfinity => false
    }


  override def ==(that: ExtendedComplexes): Boolean = {
    that match {
      case t: Complex => false
      case ComplexInfinity => true
    }
  }

  override def toString(): String = "+inf"
}

object NegativeInfinity extends NegativeInfinity {}
class NegativeInfinity extends RealInfinity() {
  def >(that: ExtendedReals): Boolean =
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => false
    }


  def <(that: ExtendedReals): Boolean =
    that match {
      case t: Reals => true
      case t: PositiveInfinity => true
      case t: NegativeInfinity => false
    }


  def ==(that: ExtendedReals): Boolean =
    that match {
      case t: Reals => false
      case t: PositiveInfinity => false
      case t: NegativeInfinity => true
    }


  def ==(that: ExtendedComplexes): Boolean =
    that match {
      case t: Complex => false
      case ComplexInfinity => true
    }


  override def toString(): String = "-inf"
}
