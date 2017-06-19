import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegateExample {

    var commonString:String by Delegates.observable("hola"){
        property: KProperty<*>, old: String, new: String ->
        TODO()
    }

    //Si se intenta de leer sin ser instanciado, tira una excepcion
    val number:Int by Delegates.notNull<Int>()

    val anotherNumber:Int by lazy { 32 }

    var myString by CustomDelegate()

    //ThisRef es la referencia a la clase, por defecto es Any?, property hace referencia a la prop
    //en si
    class CustomDelegate {
        operator fun getValue(thisRef: DelegateExample, property: KProperty<*>): String?{
            return thisRef.myString
        }

        operator fun setValue(thisRef: DelegateExample, property: KProperty<*>, value: String?) {
            thisRef.myString = value
        }
    }

}
fun main(args: Array<String>) {
    val example: DelegateExample = DelegateExample()

    example.commonString = "Hola"

    example.commonString = "NO"
}