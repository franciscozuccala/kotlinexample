package com.franciscozuccala

object AnObject{
    var someValue: Int = 30

    fun giveMeABool()=true

    fun modifySomethingInsideMe(){
        TODO("Do something with the state")
    }
}

fun main(args: Array<String>) {
    val obj = AnObject


    //Permite utilizar el objeto dentro de el scope del let, para no generar variables auxiliares
    //asi como tambien para ejecutar algo si obj no es null
    obj.let { obj -> obj.someValue == obj.someValue.div(10) }.and(false)

    //LLama a la funcion y devuelve su resultado, es como una combinacion de let y with
    obj.run { someValue == someValue.div(10) }.and(false)

    //Ejecuta la función pasada y devuelve el objeto de nuevo, con la funcion aplicada
    obj.also { obj -> obj.modifySomethingInsideMe() }.giveMeABool()

    //Combina also con with
    obj.apply { modifySomethingInsideMe() }.giveMeABool()

    //Recibe una funcion que devuelbe un bool, en caso de ser true, takeIf devuelve this, sino null
    obj.takeIf { it.giveMeABool() }

    //Recibe una funcion que devuelbe un bool, en caso de ser false, takeUnless devuelve this, sino null
    obj.takeUnless {it.giveMeABool() }

    //Permite ejecutar funciones dentro del objeto pasado por parametro
    with(obj){
        giveMeABool()
        someValue.plus(30)
    }
}


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
