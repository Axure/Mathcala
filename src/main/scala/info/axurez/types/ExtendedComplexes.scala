package info.axurez.types

/**
 * Created by zhenghu on 2016/1/11.
 */
abstract trait ExtendedComplexes {
  def ==(that: ExtendedComplexes): Boolean
}

class Complex(cRealPart: Double, cImaginaryPart: Double) extends ExtendedComplexes {

  def realPart = cRealPart
  def imaginaryPart = cImaginaryPart

  def ==(that: ExtendedComplexes): Boolean = that match {

      case t: Complex => this.realPart == t.realPart && this.imaginaryPart == t.imaginaryPart
      case t: ComplexInfinity => false

  }

  override def toString(): String = (realPart, imaginaryPart) match {
    case (0, a) => a + "i"
    case (a, 0) => a.toString
    case (a, b) => a.toString + "+" + b + "i"
  }
}

class ComplexInfinity extends ExtendedComplexes {
  def ==(that: ExtendedComplexes): Boolean = that match {
    case t: Complex => false
    case t: ComplexInfinity => true
  }

  override def toString(): String = "cinf"
}

object ComplexInfinity extends ComplexInfinity() {

}
