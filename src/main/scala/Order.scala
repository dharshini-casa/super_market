case class Order(customerId: String = "", var items: List[OrderItem] = List()) {
  val orderId = OrderIdGenerator.getOrderId()

  def addItem(item: OrderItem) = items = items :+ item

  
}
