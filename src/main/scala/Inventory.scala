class Inventory(var products: List[Product] = List()){
    def addProduct(product: Product) = {
        products = products :+ product
        println(f"$products")

        println("Inventory added.")
    }

    def getProduct(productId: String): Option[Product] = {
        products.find(_.productId == productId)
       
    }

    def updateProduct(productId: String, quantity: Double) = {
        println(f"$products")
        val product = products.find(_.productId == productId)
        println(f"$productId")
        product match {
            case Some(product) => product.updateQuantity(quantity)
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
