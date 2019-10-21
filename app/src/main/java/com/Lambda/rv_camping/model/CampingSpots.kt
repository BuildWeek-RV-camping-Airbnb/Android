package com.Lambda.rv_camping.model

import java.io.Serializable

class CampingSpots : Serializable{
    var id: String? =null
    private var details: String? = null

    constructor(details: String, id: String){
        this.details = details
        this.id = id
    }
    constructor(campingSpots: String){
        this.details = campingSpots
        this.id = campingSpots
    }
}