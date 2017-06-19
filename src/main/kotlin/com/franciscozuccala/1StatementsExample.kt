package com.franciscozuccala

class Statements {
    fun ifStatements(param: String?): String?{
        if (2 != 3){

        }else {

        }

        if (param != null) return param + "" else return ""
    }

    fun forStatements(){
        for (each:String in arrayListOf<String>("String")){

        }

        for ((index: Int, each:String) in arrayListOf<String>("String").withIndex()){

        }

        for (i:Int in 1..10 step 3){

        }

        for (i in 1 until 10 step 3){

        }

    }

    fun whileStatement(){
        val myCondition:Boolean = true
        while (myCondition){
            TODO("do something")
        }
    }

    fun doStatement(){
        val myCondition:Boolean = true
        do {
            (myCondition && false) || true
            myCondition.and(false).or(true)
        }while (myCondition)
    }

    fun whenStatement(id:Int): User?{
        when (id){
            2 -> return User(2, "Nombre2")
            3 -> return User(3, "Nombre3")
            else -> return null
        }
    }
}

