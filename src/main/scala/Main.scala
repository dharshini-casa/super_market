import scala.io.StdIn._

object Main extends App {

  var input: String = ""
  println("\t\t\t\t\t\tWelcome to Super Market.!\n") 
  println("Are you Administrator(a/A) or Customer(c/C)?\t\t\t\t")
  input = readLine().trim.toLowerCase
  if(isAdmin(input)){
    println("Welcome Admin!")
    println("Please enter admin password:\t\t\t")
    val password = readLine().trim
    val correct = Admin.checkPassword(password)

    if(correct){
      AdminCommandProcessor.menu()
      while(true){
           val command = readLine().trim()
           AdminCommandProcessor.findCommandType(command)
      }
    }
  }
  def isAdmin(input: String): Boolean = input == "a"
}