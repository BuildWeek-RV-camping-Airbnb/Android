package com.Lambda.rv_camping

import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.Properties
import com.Lambda.rv_camping.model.Property
import com.Lambda.rv_camping.model.User
import com.Lambda.rv_camping.ui.controllers.AddPlaceController
import com.Lambda.rv_camping.ui.controllers.LoginController
import org.amshove.kluent.shouldBeGreaterThan
import org.junit.Test
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotContain
import org.amshove.kluent.shouldNotEqual


class ModelTests {

val textCorrect = CampingSpots("Fake name", "Fake Description", "Fake Address", 2f)
val textFail = CampingSpots("Fake name", "Fake Description", "Fake Address", 2f)

    val propsCorrect = Property(1, "Fake Property", "Fake Description",
        "Fake Address","Fake City", "Fake State", "Fake Image", 1, 2,
        3)

    val userCorrect = User("Fake Name", "Fake Last Name", "Fake Email", "Fake Username",
    "Fake Password", true, "Fake Avatar")



    @Test
    fun testCorrectCampingFun(){

        textCorrect.address shouldEqual "Fake Address"
        textCorrect.description shouldEqual "Fake Description"
        textCorrect.price shouldEqual 2f


    }

    @Test
    fun testFailCampingFun(){
        textFail.description shouldEqual "Fail"
        textFail.price?.shouldBeGreaterThan(3f)
        textFail.address shouldNotEqual "Fake Address"
    }

    @Test
    fun testCorrectPropertiesFun() {
        propsCorrect.id shouldEqual 1
        propsCorrect.property_name shouldEqual "Fake Property"
        propsCorrect.address shouldEqual "Fake Address"
        propsCorrect.city shouldEqual "Fake City"
        propsCorrect.state shouldEqual "Fake State"
        propsCorrect.image shouldEqual "Fake Image"
        propsCorrect.price shouldEqual 1
        propsCorrect.rating shouldEqual 2
        propsCorrect.owner_id shouldEqual 3
    }

    @Test
    fun testFailPropertiesFun() {
        propsCorrect.id shouldNotEqual 1
        propsCorrect.property_name shouldNotEqual "Fake Property"
        propsCorrect.address shouldNotEqual "Fake Address"
        propsCorrect.city shouldNotEqual "Fake City"
        propsCorrect.state shouldNotEqual "Fake State"
        propsCorrect.image shouldNotEqual "Fake Image"
        propsCorrect.price shouldNotEqual 1
        propsCorrect.rating shouldNotEqual 2
        propsCorrect.owner_id shouldNotEqual 3
    }

    @Test
    fun testUserCorrectFun(){
        userCorrect.first_name shouldEqual "Fake Name"
        userCorrect.last_name shouldEqual "Fake Last Name"
        userCorrect.email shouldEqual "Fake Email"
        userCorrect.avatar shouldEqual "Fake Avatar"
        userCorrect.owner shouldEqual true
    }

    @Test
    fun testUserFailFun(){
        userCorrect.first_name shouldNotEqual "Fake Name"
        userCorrect.last_name shouldNotEqual "Fake Last Name"
        userCorrect.email shouldNotEqual "Fake Email"
        userCorrect.avatar shouldNotEqual "Fake Avatar"
        userCorrect.owner shouldNotEqual true
    }

}

