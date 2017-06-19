package com.franciscozuccala

class MyClass{
    val myStringVariable: String = "String"
    var myMutableStringVariable : String? = null

    fun aCommonFunction(param:String){
        TODO()
    }
}

fun main(args: Array<String>) {
    val value = 2
    val myClass = MyClass()
    myClass.myMutableStringVariable = "New Value $value"
    myClass.aCommonFunction("Parameter")
}