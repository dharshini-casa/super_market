package model

case class OrderItem(productId: String, quantity: Double){
    def getQuantity() = quantity
    
}
