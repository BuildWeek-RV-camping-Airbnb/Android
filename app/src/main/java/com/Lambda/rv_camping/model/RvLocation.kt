package com.Lambda.rv_camping.model

import android.location.Location
import java.io.Serializable

class RvLocation{
    var name:String?=null
    var des:String?=null
    var image:Int?=null
    var location : Location?=null
    constructor(name:String, des:String, image:Int, lat:Double, log:Double){
        this.name = name
        this.des = des
        this.image = image
        this.location = Location(name)
        this.location!!.latitude = lat
        this.location!!.longitude = log
    }
}