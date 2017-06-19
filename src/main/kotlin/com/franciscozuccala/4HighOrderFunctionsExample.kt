package com.franciscozuccala

class FunctionClass {

    fun letExample(id: Int = 32) {
        val user = User()
        user.let {
            it.id = id
            it.name = "Name"
        }

        val listWithNulls: List<String?> = listOf("A", null)

        //Tambien recorre nulls
        for (item in listWithNulls) {
            //como puede pasar por nulls es necesario el checkeo
            //igual, los nulls permiten ejecutar la funcion let
            item?.let { println(it) }
        }

        for (item in listWithNulls.filter { it != null }) {
            item.let { println(it + " ") }
        }

        //Esto tira una excepcion si encuentra un null
        for (item in listWithNulls.requireNoNulls()) {
            println(item)
        }

    }

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