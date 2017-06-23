package com.franciscozuccala

import java.util.*

class MyClass{
    val myStringVariable = "String"
    var myMutableStringVariable : String? = null

    fun aCommonFunction(param:String):String{
        TODO()
    }
}

class ClassWithGetters{
    private var privateVar = 34
    set(value) {
        println(value)
        privateVar = value
    }

    var edad = 32
        private set

    val esMayorDeEdad: Boolean
        get() = (edad >= 18)

    fun a(){
        edad = 2
    }
}

fun main(args: Array<String>) {
    val value = 2
    val myClass = MyClass()
    myClass.myMutableStringVariable = "New Value ${value + 2}"
    myClass.aCommonFunction("Parameter")

    val classWithGetters = ClassWithGetters()
    classWithGetters.edad

    val scanner = Scanner(System.`in`)
    val nextLine: String = scanner.nextLine()

}