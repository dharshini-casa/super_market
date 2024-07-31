case class BillProcessor(order: Order, productCatalogue: ProductCatalogue) {
   
    def calculateNetPrice(price: Double, quantity: Double) = price * quantity
    
    def calcualteTotalPrice = {
        val items = order.items
        val totalPrice = items.map(item => calculateNetPrice(productCatalogue.getProductPrice(item.productId) , item.quantity)).sum
        totalPrice
    }

    def generateBill = {
        val items = order.items
        val billItems = items.map( item => 
            val product = productCatalogue.getProduct(item.productId)
            val quantity = item.quantity
            val price = productCatalogue.getProductPrice(item.productId) 
            val netPrice = calculateNetPrice(price, quantity)
            BillItem(product, quantity, netPrice)
        ).toList
        
        val totalPrice = calcualteTotalPrice
        Bill(billItems, totalPrice)
    }
}


case class BillItem(product: Option[Product], quantityBought: Double, netPrice: Double)