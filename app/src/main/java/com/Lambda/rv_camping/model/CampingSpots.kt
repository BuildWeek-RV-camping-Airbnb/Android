package com.Lambda.rv_camping.model

import java.io.Serializable

class CampingSpots : Serializable{
    var id: String? =null
    var image: Int? = null
    var property_name: String? = null
    var address: String? = null
    var description: String? = null
    var price: Float? = null
    var reserved: String? = null
    var isReserved: Boolean? = false

    constructor(property_name: String, description: String, address: String, price: Float){
        this.description = description
      //  this.id = id
        this.property_name = property_name
        this.address = address
        this.price = price




    }
    constructor(campingSpots: String){
        this.description = campingSpots
        //this.id = campingSpots
        this.property_name = campingSpots
        this.address = campingSpots
        this.price = campingSpots.toFloat()

    }
}
