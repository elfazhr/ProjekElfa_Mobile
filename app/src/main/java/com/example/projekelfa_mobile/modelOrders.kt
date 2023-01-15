package com.example.projekelfa_mobile

class modelOrders {

    var id:String = ""
    var bread:String = ""
    var amount:String = ""
    var prices:String = ""
    var notes:String = ""
    var timestamp:Long = 0
    var uid:String = ""

    constructor()

    constructor(
        id: String,
        bread: String,
        amount: String,
        prices: String,
        notes: String,
        timestamp: Long,
        uid: String
    ) {
        this.id = id
        this.bread = bread
        this.amount = amount
        this.prices = prices
        this.notes = notes
        this.timestamp = timestamp
        this.uid = uid
    }


}