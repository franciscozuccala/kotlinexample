package com.franciscozuccala

object ReifiedTypeExample {

    fun <T> aFuncitonToUseClass(clazz:Class<T>){
        clazz.annotations
    }

    //Al user reified types, te obliga a agregar la palbra inline, esto implica
    //que como la funcion va a ser copiada y pegada donde se utilice, el tipo T
    //va a ser una instancia realmente, por lo cual no va a haber necesidad de pasar la
    //clase por parametro o alguna otra forma
    inline fun <reified T> aFunctionWithoutNeedOfClass(){
        T::class.java.annotations
    }
}

fun main(args: Array<String>) {
    ReifiedTypeExample.aFuncitonToUseClass(AnotherClass::class.java)

    ReifiedTypeExample.aFunctionWithoutNeedOfClass<AnotherClass>()
}

class AnotherClass