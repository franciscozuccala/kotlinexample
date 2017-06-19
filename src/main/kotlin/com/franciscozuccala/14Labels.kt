package com.franciscozuccala

class Labels {


    open fun howToPutLabels(){

        val a = this@Labels

        run hola@{
            (1..20).forEach {
                return@hola
            }
        }

    }

}

fun returnInsideLambda(block:()->Unit){

    loop@for(each in 2..10){

        break@loop
    }
}

fun main(args: Array<String>) {

    returnInsideLambda {
        if (true){
            println("hola")
            //No es recomendado, pero para hacer un return dentro de un lambda, se hace un con label
            return@returnInsideLambda
        }
        println("Chau")
    }

}