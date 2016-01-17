package info.axurez.parser

class NaturalParser(
                     variables: List[String] = List("x", "y")
                     ) extends GeneralParser {
  override def toString: String = {
    return this.variables.mkString(", ")
  }

}

object NaturalParser extends NaturalParser(List("x", "y")) {


}
