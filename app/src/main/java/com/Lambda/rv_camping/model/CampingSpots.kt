package com.Lambda.rv_camping.model

class CampingSpots{
    var id: String? =null
    private var details: String? = null

    constructor(details: String, id: String){
        this.details = details
        this.id = id
    }
    constructor(campingSpots: CampingSpots){
        this.details = campingSpots.details
        this.id = campingSpots.id
    }
}