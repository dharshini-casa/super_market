object SuperMarket {
  val productCatalogue = ProductCatalogue()
  val inventory = Inventory()
  val order = Order()
}

trait Processor {
  val productCatalogue = SuperMarket.productCatalogue
  val inventory = SuperMarket.inventory
  val order = SuperMarket.order

  // def menu(): Unit
}


object AdminProcessor extends Processor{
      
    def menu(): Unit = {
        println("1) To add product use inventory command")
        println("2) To update the sold products use sale command")
        println("3) To check the stock of prouct use stock command")
        println("4) To exit use exit command\n")

        println("Commmands:")
        println("INVENTORY=>Product ID|Product Name|Quantity|Price Per Quantity")
        println("SALE=>Product Id|Quantity;Product Id|Quantity \n\tNote: \";\" is for mutiple products")
        println("STOCK=>Product Id")
        println("EXIT / exit")
    }
    

    def findCommandType(input: String) = {
        if(input.startsWith("INVENTORY")) InventoryProcessor.updateInventory(input)
        else if(input.startsWith("SALE")) SaleProcessor.makeSale(input)
        else if(input.startsWith("STOCK")) StockProcessor.printStock(input)
        else if(input.startsWith("exit") || input.startsWith("EXIT")){
          println("Administor exited.")
          System.exit(0)
        }
        else println("Invalid command")
    }
  
    
}

object InventoryProcessor extends Processor{

  def updateInventory(input: String) = {
      val value = InputParser.arrowDelimiterParse(input)
      val productDetails = InputParser.pipeDelimiterParse(value)
      
      val productId = productDetails(0).trim
      val productName = productDetails(1).trim
      val quantity = productDetails(2).toDouble
      val price = productDetails(3).toDouble
      
      productCatalogue.addProduct(productId, productName, price)
      inventory.addProduct(productId, quantity)


  }
}

object SaleProcessor extends Processor{

  def makeSale(input: String) = {
      println("Inside makeSale")
      val value = InputParser.arrowDelimiterParse(input)
      val sales = InputParser.semicoloDelimiterParse(value)
      
      sales.foreach { sale =>
        val saleDetails = InputParser.pipeDelimiterParse(sale)
        val productId = saleDetails(0).trim
        val quantity = saleDetails(1).toDouble

        inventory.updateStock(productId, quantity)
        val orderedItem = OrderItem(productId, quantity)
        order.addItem(orderedItem)
      }
      makeBill
  }

  def makeBill = {
      println("Inside makeBill")
      val billProcessor = BillProcessor(order, productCatalogue)
      val bill = billProcessor.generateBill
      val billPrinter = BillPrinter(bill)
      billPrinter.printBill
  }
}

object StockProcessor extends Processor{

  def printStock(input: String) = {
    val productId = InputParser.arrowDelimiterParse(input)
    val avaiableStock = inventory.getStock(productId) 
    println(f"$avaiableStock")
  }
}