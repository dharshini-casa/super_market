case class Product(productId: String, productName: String, var quantity: Int, pricePerQuantity: Double){
    def updateQuantity(newQuantity: Int): Unit =  {
        if(newQuantity > quantity) println(f"$productName ")
        quantity = quantity - newQuantity

    }
}
