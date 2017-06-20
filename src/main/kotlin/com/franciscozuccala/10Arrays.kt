package com.franciscozuccala

class WithMap(val map: Map<String, Any?>){
    val name: String by map
    val age: String by map

    //Esto es un ejemplo, no esta bueno usar este get, para acceder a las propiedades
    operator fun get(attribute:String): String?{
        when (attribute){
            "name" -> return name
            "age" -> return  age
            else -> return null
        }
    }
}

fun main(args: Array<String>) {
    val withMap = WithMap(mapOf(
            "name" to "MyName",
            "age" to 3
    ))

    withMap["name"]

    mapOf("name" to "hola")["name"]

    val anotherDefinitionForMap = mapOf(Pair(3,"hola"))
    anotherDefinitionForMap[3]

    listOf(3,4,6)[2]

    mutableListOf<String>().add("String")
}
