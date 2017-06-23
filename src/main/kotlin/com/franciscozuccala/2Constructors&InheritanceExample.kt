package com.franciscozuccala

open class User constructor(val dni:Int = 32, override val someVal: Int) : Person(dni), Named, AnotherNamed{

    override fun sayName(): String {
        return super<Named>.sayName()
    }

    final override fun sayBye(): String {
        return super.sayBye()
    }

    constructor():this(1, 23)

    constructor(dni: Int, name:String):this(dni, 23){
        this.name = name
    }

    init {

    }

    lateinit var name : String

}

open class Person(var id: Int){
    open fun sayBye():String{
        return "Bye"
    }

    fun a(name:String = "hola"){
        id
    }
}

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

class Outer{
    class Nested{
        fun sayHi()="hola"
    }

    inner class Inner{
        fun pepe(){
            this@Outer
        }
        fun sayHi()="hola"
    }
}

fun main(args: Array<String>) {
    Outer.Nested().sayHi()
    Outer().Inner().sayHi()
}