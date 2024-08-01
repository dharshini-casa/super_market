trait  Parser {
  def parse(input: String): String
}

object InputParser extends Parser{

  def arrowDelimiterParse(input: String):  String = {
    val parts = input.split("=>")
    val inputType = parts(0).trim
    val inputValue = parts(1).trim
     inputValue
  } 

  def semicoloDelimiterParse(input: String): List[String] = {
    val orderDetails = input.split(";")
    orderDetails.toList
  }

  def pipeDelimiterParse(input: String): List[String] = {
      val parts = input.split("\\|")
      parts.toList
  }

  def parse(input: String): String = ???

}

