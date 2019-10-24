package com.Lambda.rv_camping

import com.Lambda.rv_camping.adapter.PropertiesAdapter
import com.Lambda.rv_camping.model.Property
import org.amshove.kluent.shouldEqual
import org.junit.Test
import org.mockito.Mock

class PropertiesAdapterTest {
    @Mock
    val propertiesAdapter: PropertiesAdapter?= null

    @Test
    fun test(){
        val test = propertiesAdapter?.itemCount

        test shouldEqual null
    }
}