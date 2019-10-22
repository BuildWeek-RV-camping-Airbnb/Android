package com.Lambda.rv_camping.model

import java.io.Serializable

class CampingSpots : Serializable{
    var id: String? =null
    var image: Int? = null
    var title: String? = null
    var details: String? = null
    var reserved: String? = null
    var isReserved: Boolean? = false

    constructor(details: String, title: String){
        this.details = details
      //  this.id = id
        this.title = title



    }
    constructor(campingSpots: String){
        this.details = campingSpots
        //this.id = campingSpots
        this.title = campingSpots

    }
}
