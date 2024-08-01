import scala.io.StdIn._
import processor.AdminCommandProcessor

object Main extends App {

  var input: String = ""
  println("\t\t\t\t\t\tWelcome to Super Market.!\n") 
  AdminCommandProcessor.menu()
  while(true){
    val command = readLine().trim()
    AdminCommandProcessor.findCommandType(command)
  }
}