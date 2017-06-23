package com.franciscozuccala

class ExtensionFunctions{

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
        return  (param + HaveName("Hola")).sayName()
    }
}

class HaveName(val name : String) : Named{
    override fun sayName(): String {
        TODO("not implemented")
    }
}

fun <T>List<T>.lambdaWithReceiver(body: List<T>.() -> Unit){
    body()
}

var ExtensionFunctions.myVar: Int
    get() = 32
    set(value){myVar = value}

fun main(args: Array<String>) {
    val letFunctions = ExtensionFunctions()

    val name: String = "name"
    println(letFunctions.protocolFunction(HaveName(name))?.let {
        user -> "id: $user"
    } ?: "user not found")

    val list = mutableListOf("arg1","arg2")
    list.lambdaWithReceiver {
        listIterator()
    }
}