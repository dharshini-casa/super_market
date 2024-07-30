import scala.io.StdIn._
case class Product(productId: String, productName: String, Quantity: Double, pricePerQuantity: Double)

object Main extends App{
  
  var products: List[Product] = ???;
  val input = readLine().trim()


  



  def addProduct(productId: String, productName: String, quantity: Double, pricePerQuantity: Double): Unit = {
      val product: Product = Product(productId, productName, quantity, pricePerQuantity)
  
      products = products :+ product
  }
  
  def getProduct(details: String): Any = {
    val parts = details.split("//|")
    val productId = parts(0)
    val productName = parts(1)
    val quantity = parts(2).toDouble
    val price = parts(3).toDouble

    addProduct(productId, productName, quantity, price)
  }

  def getSales(sales: String): Any = {
    val parts = sales.split(";")

    
  }
}
