import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegateExample {

    var commonString:String by Delegates.observable("hola"){
        property: KProperty<*>, old: String, new: String ->
        TODO()
    }

    //Si se intenta de leer sin ser instanciado, tira una excepcion
    var number:Int by Delegates.notNull<Int>()

    val anotherNumber:Int by lazy {
        println("computed")
        23
    }

    var myString by CustomDelegate()

    //ThisRef es la referencia a la clase, por defecto es Any?, property hace referencia a la prop
    //en si
    class CustomDelegate {
        operator fun getValue(thisRef: DelegateExample, property: KProperty<*>): String?{
            return "Hola"
        }

        operator fun setValue(thisRef: DelegateExample, property: KProperty<*>, value: String?) {

        }
    }

}
fun main(args: Array<String>) {
    val example: DelegateExample = DelegateExample()

    println(example.anotherNumber)
    println(example.anotherNumber)


    println(example.myString)
    example.myString = "hola"
    println(example.myString)
}