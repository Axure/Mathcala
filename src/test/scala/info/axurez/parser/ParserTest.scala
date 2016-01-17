package info.axurez.parser

import org.scalatest._

object ParserTest extends FlatSpec with Matchers {
  def main(args: Array[String]) {

    val parser = NaturalParser
    println(parser)

  }

}
