case class Bill(items: List[BillItem], totalAmount: Double) {
  val billDate = Date.getDate()
  val billTime = Time.getTime()
  val billId = BillIdGenerator.getBillId()
}

