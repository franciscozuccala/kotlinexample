package com.franciscozuccala

class User constructor(val dni:Int, override val someVal: Int) : Person(dni), Named, AnotherNamed{

    override fun sayName(): String {
        return super<Named>.sayName()
    }

    constructor():this(1, 23)

    constructor(dni: Int, name:String):this(dni, 23){
        this.name = name
    }

    init {

    }

    lateinit var name : String

}

open class Person(var id: Int)

interface Named{
    fun sayName():String{
        return "Name One"
    }
}

interface AnotherNamed{
    val someVal: Int

    fun sayName():String{
        return "Name Two"
    }
}
