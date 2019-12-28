package letcheerful.algorithm.sort

import letcheerful.algorithm.hackerrank.swap
import org.junit.Assert
import org.junit.Test
import java.lang.Math.min
import java.lang.Math.random


class Kotlin {

    inline fun test(code: () -> Unit) {
        code.invoke()
    }

    @Test
    fun testSearchLast() {
        val code = {
            println("Run code!")
        }
        test(code)
    }

    data class Address(var street: String? = null,
                       var number: Int? = null,
                       var city: String? = null)


    fun address(block: Address.() -> Unit) = Address().apply(block)

    data class Person(var name: String? = null,
                      var age: Int? = null,
                      var address: Address? = null)


    fun person(block: Person.() -> Unit): Person = Person().apply(block)


    @Test
    fun kotlinDSLTest() {
        val person = person {
            name = "John"
            age = 25
            address {
                street = "Main Street"
                number = 42
                city = "London"
            }
        }



    }

}

/*
* Before = [3, 1, 2]
Array = [2, 1, 3], leftIndex = 0, rightIndex = 2
Array = [2, 1, 3], leftIndex = 1, rightIndex = 1
After = [2, 1, 3]
*
*
* */