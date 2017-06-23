package com.franciscozuccala

class Statements {
    fun ifStatements(param: String?): String?{
        if (2 != 3){

        }else {

        }

        if (param != null) return param + "" else return ""
    }

    fun forStatements(){
        listOf("hola","hola")

        for (each in arrayListOf<String>("String")){

        }

        for ((index: Int, each:String) in arrayListOf<String>("String").withIndex()){

        }

        for (i:Int in 1..10 step 3){

        }

        for (i in 1 until 10 step 3){

        }

        for (i in 20 downTo 10 step 2){

        }

    }

    fun whileStatement(){
        val myCondition:Boolean = true
        while (myCondition){
            TODO("do something")
        }
    }

    fun doStatement(){
        var myCondition:Boolean = true
        do {
            myCondition = myCondition.and(false).or(true)
        }while (myCondition)
    }

    fun whenStatement(id:Int): User?{
        when (id){
            2 -> return User(2, "Nombre2")
            3 -> return User(3, "Nombre3")
            4,5 -> return User(4, "Nombres")
            else -> return null
        }
    }
}

