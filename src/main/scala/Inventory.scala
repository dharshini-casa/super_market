class Inventory(var products: List[Product] = List()){
    def addProduct(product: Product) = {
        products = products :+ product
        println("Inventory added.")
    }

    def getProduct(productId: String): Option[Product] = {
        products.find(_.productId == productId)
       
    }

    def updateProduct(productId: String, quantity: Int) = {
        val product = products.find(_.productId == productId)
        product match {
            case Some(product) => {
                if(product.quantity < quantity) 
                   println(f"Error: Insufficient quanity to update product ${product.productName}.\n Available quantity: ${product.quantity}, Requested Quantity: $quantity")
                else
                   product.updateQuantity(quantity)
            }
            case None => println("Product not found updated")
        }
    }



    def getStock(productId: String) = {
        val product = products.find(_.productId == productId)
        product match {
            case Some(product) => (product.productName, product.quantity)
            case None => println("Product not found")
        }
    }

    override def toString: String = {
        products.map(p => s"${p.productId} - ${p.productName} - ${p.quantity} - ${p.pricePerQuantity}").mkString("\n")
    }
}
