
class ReflectionExample {
    //this say the params that recive, and the return type
    fun receiveFunctionByReflection(funct:(value:String, value2:String) -> String, value: String): String{
        return funct (value, value)
    }
}

fun main(args: Array<String>) {
    val reflectionExample = ReflectionExample()

    //In line function
    fun example (a: String, b:String): String = a+b

    //The '::' makes reference to reflection
    reflectionExample::class
    reflectionExample::class.java.annotations

    reflectionExample::class.java.fields

    println(reflectionExample.receiveFunctionByReflection(::example,"value"))
}