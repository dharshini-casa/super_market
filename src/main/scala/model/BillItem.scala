package model

case class BillItem(product: Option[Product], quantityBought: Double, netPrice: Double)
