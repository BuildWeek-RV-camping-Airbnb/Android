package com.Lambda.rv_camping.ui.activities

import com.Lambda.rv_camping.R
import org.amshove.kluent.shouldEqual
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MainActTest {

    val mainActivity = MainActivity()
    @Test
    fun inflateTest(){

        val test = mainActivity.setContentView(R.layout.activity_main)
       test shouldEqual test
    }

   /* @Before
    fun setUp() {
    }*/

   /* @After
    fun tearDown() {
    }*/

   /* @Test
    fun onCreate() {

    }*/

   /* @Test
    fun onBackPressed() {
    }*/
}