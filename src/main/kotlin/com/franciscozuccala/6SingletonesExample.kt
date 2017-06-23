class SingletonesExample {
    companion object Factory{

        const val LIKE_A_CONSTANT ="Hello"
        @JvmField
        val likeAnStaticVar: String = "Static var"
        @JvmStatic
        fun staticFunction():Unit= TODO()
    }
}

object ThisIsASingletone{
    val likeAnStaticVar : String = "Static var"

    fun aFunction(){
        val instance = object : NormalInterface{
            override fun aNormalMethod() {
                TODO("not implemented")
            }
        }

        val normalInstancec = object : NormalClass(){
            override fun justAClassMethod() {
                TODO("not implemented")
            }
        }

        giveMeAnObject().aVal
    }

    //The functions that return an anonyimous object can only be private
    //otherwise the return type will be Any?
    private fun giveMeAnObject() = object {
        val aVal= "Val"
        lateinit var aVar:String
    }
}

abstract class NormalClass{
    abstract fun justAClassMethod()
}

interface NormalInterface{
    fun aNormalMethod()
}


fun main(args: Array<String>) {
    ThisIsASingletone.likeAnStaticVar

    SingletonesExample.LIKE_A_CONSTANT
    SingletonesExample.Factory.staticFunction()

    val adHoc = object {
        val x : Int=0
        val y : Int=0
    }

    adHoc.x

}