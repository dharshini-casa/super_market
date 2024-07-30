class Bill(inventory: Inventory) {
   var totalAmount: Double = 0.0
   def calculateNetPrice(productId: String, quantitySold: Double) = {
     val product = inventory.getProduct(productId)
     product match {
        case Some(product) => {
          val netPrice = product.pricePerQuantity * quantitySold
          totalAmount += netPrice
          netPrice
        }

        case None => print("Product not found")
     } 
   }

   def printProductBill(productId: String, quantitySold: Double) = {
     val netPrice = calculateNetPrice(productId, quantitySold)
     val product = inventory.getProduct(productId)
     product match {
       case Some(prod) => println(f"$productId - ${prod.productName}- $quantitySold - ${prod.pricePerQuantity} - N/A -$netPrice")
       case None => print("Product not found")
     }      
    }
   
   
   def printTotal() = {
    println(f"$totalAmount")
   }
}
