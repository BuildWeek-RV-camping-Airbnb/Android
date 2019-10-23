package com.Lambda.rv_camping.model

import java.io.Serializable
/*this data class is create for data that is specifically used for maps, to get users coordinates*/
data class RvLocation(
    val street: String,
    val city: String,
    val state: String,
    val postcode: String,
    val coordinates: ContactLocationCoordinates
) : Serializable

data class ContactLocationCoordinates(val latitude: Double, val longitude: Double): Serializable