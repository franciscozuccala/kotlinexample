package com.franciscozuccala

class FunctionClass {

    inline fun highOrderFunction(body:() -> Unit): Boolean{
        try{
            body()
            return true
        }catch (e: Exception) {
            return false
        }
    }

    //Checkear que pasa cuando se retira el parametro body (el noinline pisa al inline y no ayuda a la performance)
    inline fun withNoInLine(body:()-> Unit, noinline block:()->String){
        TODO()
    }

    //Se utiliza el crossinline, cuando la funcion recibida, sea utilizada en otro contexto, ej
    //Esto es porque las funciones normalmente estan asociadas a un contexto local al ser inline, mientras que si
    //se neceista ser utilizada en otro ambiente se debe notificar como crossinline
    inline fun f(crossinline body: () -> Unit) {
        val f = Runnable { body() }
    }

    fun highOrderFunctionWithParams(param: String, body:(String)->String): String{
        return body(param)
    }

    fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
        TODO()
    }
}

fun main(args: Array<String>) {
    val functions = FunctionClass()

    fun anotherFunction(){
        println("Im in a function")
    }

    functions.highOrderFunction {
        println("Im in a function")
    }

    functions.highOrderFunction ({
        println("Im in a function")
    })

    functions.highOrderFunctionWithParams("Param"){
        "Im in a function"
    }

    functions.highOrderFunction (fun():Unit{
        println("Im in a function")
    })

    functions.highOrderFunctionWithParams(param = "Param", body =  fun (arg:String): String{
        return "Im in a function"
    })

    functions.highOrderFunction(::anotherFunction)

    functions.highOrderFunction { anotherFunction() }
}