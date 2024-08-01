package utilites

trait IdGenerator {
  
}


object OfferIdGenerator extends IdGenerator {
    private var offerId: Int = 0

    def getofferId(): Int = offerId + 1
}

object CustomerIdGenerator extends IdGenerator {
    private var customerId: Int = 0

    def getCustomerId(): Int = customerId + 1
}

object BillIdGenerator extends IdGenerator {
    private var billingId: Int = 0
    
    def getBillId(): Int = billingId + 1
}

object OrderIdGenerator extends IdGenerator {
    private var orderId: Int = 0

    def getOrderId(): Int = orderId + 1
}