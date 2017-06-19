package com.franciscozuccala

class User constructor(val dni:Int) : Person(dni), Named{

    override fun sayName(): String {
        TODO()
    }

    constructor():this(1)

    constructor(dni: Int,name:String):this(dni){
        this.name = name
    }

    init {

    }

    lateinit var name : String

}

open class Person(var id: Int)

interface Named{
    fun sayName():String
}
