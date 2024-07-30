import scala.io.StdIn._

object Main extends App {

   var input: String = ""
   val inventory = new Inventory()
   while(true){
    input = readLine().trim
    if(input == "quit" || input == "q") System.exit(0)
    val inputType = input.split("=>")(0).trim()
    val inputValue = input.split("=>")(1).trim()

    if(inputType == "INVENTORY") {
      val prod_details = inputValue.split("\\|")
      val produtId = prod_details(0).trim()
      val productName = prod_details(1).trim()
      val quantity = prod_details(2).trim().toInt
      val price = prod_details(3).trim().toDouble
      
      val product = new Product(produtId, productName, quantity, price)
      inventory.addProduct(product)
  

    }else if(inputType == "SALE"){
      val sales = inputValue.split(";")
      val bill = new Bill(inventory)
      println("== BILL ==")
      sales.foreach { sale =>
        val saleDetails = sale.split("\\|")
        val productId = saleDetails(0).trim()
        val quantitySold = saleDetails(1).trim().toInt
           
        inventory.updateProduct(productId, quantitySold)
        bill.printProductBill(productId, quantitySold)       
      }
      println("== TOTAL ==")
      bill.printTotal()

    }else if(inputType == "STOCK"){
        val productId = inputValue
        val stock_detail = inventory.getStock(productId)
        stock_detail match {
          case (productName, quantity) =>  println(f"$productName - $quantity")
          case _ => println("Product not found")
        }
   }else{
    println("Invalid Input")
   }   

   }
  
}