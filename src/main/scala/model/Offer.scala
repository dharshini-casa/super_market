package model
import utilites.*
class Offer(offerName: String, offerPercentage: Double) {
    val offerId = OfferIdGenerator.getofferId()
    val date = Date.getDate()
    val time = Time.getTime()

}


