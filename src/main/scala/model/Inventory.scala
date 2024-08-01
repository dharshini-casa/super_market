package model

import scala.collection.mutable.Map

class Inventory(var stocks: Map[String, Double] = Map()){
    def addProduct(productId: String, quantity: Double) = {
        stocks += (productId -> quantity)
        println("Inventory added.")
    }

    def removeProduct(productId: String) = {
        stocks -= productId
        println("Inventory removed.")
    }
    
    def isProductPresent(productId: String): Boolean = {
        val isPresent = stocks.contains(productId)
        if (!isPresent) println("Product not found in inventory.")
        isPresent
    }

    def getStock(productId: String) = {
        if(isProductPresent(productId)) {
            val stock = stocks(productId)
            stock
        } else 0
    }  

    def checkAvailability(productId: String, quantity: Double): Boolean = {
        var stock = 0.0
        var isAvailable = false
        if(isProductPresent(productId)){
            stock = stocks(productId)  
            isAvailable = stock >= quantity  
            if(!isAvailable) println(f"Insufficient stock. Avaliable quantity: $stock, Requested quantity: $quantity")
        }
        isAvailable    

    }
  
    def updateStock(productId: String, quantity: Double) = {
        if(isProductPresent(productId)){
            if(checkAvailability(productId, quantity)){
                val stock = stocks(productId)
                stocks(productId) = stock - quantity
            }
        }
    }
    

}
 