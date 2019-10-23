package com.Lambda.rv_camping

import com.Lambda.rv_camping.model.CampingSpots
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


    @Test
    fun testCorrectFun(){

        textCorrect.address shouldEqual "Fake Address"
        textCorrect.description shouldEqual "Fake Description"
        textCorrect.price shouldEqual 2f


    }

    @Test
    fun testFailFun(){
        textFail.description shouldEqual "Fail"
        textFail.price?.shouldBeGreaterThan(3f)
        textFail.address shouldNotEqual "Fake Address"
    }


}