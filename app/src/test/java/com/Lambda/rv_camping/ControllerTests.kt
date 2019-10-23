package com.Lambda.rv_camping

import com.Lambda.rv_camping.model.CampingSpots
import org.junit.Test
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotEqual


class ControllerTests {

val textCorrect = CampingSpots("Fake name", "Fake Description", "Fake Address", 2f)
val textFail = CampingSpots("Fake name", "Fake Description", "Fake Address", 2f)

    @Test
    fun testCorrectFun(){

        textCorrect.address shouldEqual "Fake Address"
        textCorrect.description shouldEqual "Fake Description"
        textCorrect.price shouldEqual 2f


    }


}