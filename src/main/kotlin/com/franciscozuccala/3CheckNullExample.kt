package com.franciscozuccala

class CommonClass(val name: String){
    fun giveMeAnotherCommonClass():CommonClass?{
        return CommonClass("String")
    }
}

fun main(args: Array<String>) {
    val commonClass = CommonClass("Another String")

    commonClass.giveMeAnotherCommonClass()?.name

    commonClass.giveMeAnotherCommonClass()!!.name

    var nameOfCommon = commonClass.giveMeAnotherCommonClass()?.name ?: "Default"

    //var nameOfCommon = commonClass.giveMeAnotherCommonClass()?.name?.let {  }
}