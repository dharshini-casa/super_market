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
     println(f"$productId - $product.productName - $quantitySold - $product.pricePerQuantity - N/A -$netPrice")
   }
   
   def printTotal() = {
    println(f"$totalAmount")
   }
}
