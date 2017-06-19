package com.franciscozuccala

class WithMap(val map: Map<String, Any?>){
    val name: String by map
    val age: String by map
}

fun main(args: Array<String>) {
    val withMap = WithMap(mapOf(
            "name" to "MyName",
            "age" to 3
    ))

    listOf(3,4,6)[2]

    mutableListOf<String>().add("String")
}
