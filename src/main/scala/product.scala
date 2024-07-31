

case class Product(productId: String, productName: String, pricePerQuantity: Double)



case class ProductCatalogue(var products: Map[String, Product] = Map()){

    def addProduct(productId: String, productName: String, pricePerQuantity: Double) = {
        val newProduct = Product(productId, productName, pricePerQuantity)
        products += (productId -> newProduct)
    }

    def isProductPresent(productId: String): Boolean = {
        val isPresent = products.contains(productId)
        if (!isPresent) println("Product not found in inventory.")
        isPresent
    }

    def getProduct(productId: String): Option[Product] = {
        if(isProductPresent(productId))   Some(products(productId))
        else None
    }

    def getProductPrice(productId: String) = products(productId).pricePerQuantity
}