package model

import utilites.{CustomerIdGenerator}
class Customer(customerName: String, phoneNumber: String, cart: List[OrderItem]) {
    val customerId = CustomerIdGenerator.getCustomerId()
    
}

