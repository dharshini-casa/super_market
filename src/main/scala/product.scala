case class Product(productId: String, productName: String, var quantity: Double, pricePerQuantity: Double){
    def updateQuantity(newQuantity: Double): Unit =  {
        quantity = newQuantity
    }
}
