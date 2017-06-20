package com.franciscozuccala

class ExtensionFunctions{

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