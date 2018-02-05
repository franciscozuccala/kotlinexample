package com.franciscozuccala

class ExtensionFunctions{

    val si = "hola"

    //Extension properties
    val <T> List<T>.lastIndex:Int
        get() = size - 1

    //Extension functions
    infix fun Int.add(another:Int): Int{
        return this + another
    }

    infix operator fun Named.plus(anotherNamed: Named): Named{
        3 add 4

        return HaveName(anotherNamed.sayName())
    }


    fun <T:Named> protocolFunction(param:T): String?{
        return  (param plus HaveName("Hola")).sayName()
    }
}

class HaveName(val name : String) : Named{
    override fun sayName(): String {
        TODO("not implemented")
    }
}

//Function literals with receiver

object MyObject{
    val hola:String = "Se"
}
// I am saying that internalFunction is gonna be executed inside MyObject
fun MyObject.myFunction(internalFunction: MyObject.() -> Unit){
    MyObject.myFunction(internalFunction)
}

fun ExtensionFunctions.hola(){
    MyObject.myFunction {
        println(hola)
    }
}

fun <T>List<T>.lambdaWithReceiver(body: (List<T>) -> Unit){
    body(this)
}

fun hola(body: (ExtensionFunctions)->Unit){
}

var ExtensionFunctions.myVar: Int
    get() = 32
    set(value){myVar = value}

fun main(args: Array<String>) {
    val letFunctions = ExtensionFunctions()
    letFunctions.hola()

    val name: String = "name"
    println(letFunctions.protocolFunction(HaveName(name))?.let {
        user -> "id: $user"
    } ?: "user not found")

    val list = mutableListOf("arg1","arg2")

    list.lastIndex

    list.lambdaWithReceiver {
        it.indexOf("hola")
    }
}