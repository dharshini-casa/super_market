case class Bill(items: List[BillItem], totalAmount: Double) {
  val billDate = Date.getDate()
  val billTime = Time.getTime()
  val billId = BillIdGenerator.getBillId()
}

class BillPrinter(bill: Bill){

  def printBill = {
    

    println("=== Bill ===")
    val date = bill.billDate
    val time = bill.billTime
    val billno = bill.billId
    println(f"Date: $date\t\t\t\t\t\t\t\t\t\t\t\t\t$billno")
    println(f"$time")
    println("")
    val items = bill.items
    val totalAmount = bill.totalAmount
    items.foreach { item =>
      val quantity = item.quantityBought
      val netPrice = item.netPrice
      item.product match {
           case Some(product) => 
                val productId = product.productId
                val productName = product.productName
                val price = product.pricePerQuantity
                println(f"$productId - $productName - $quantity - $price - N/A - $netPrice")
           case None => println("product not found")
      }     
    }

    println("=== Total ===")
    println(f"$totalAmount")
  }
}


