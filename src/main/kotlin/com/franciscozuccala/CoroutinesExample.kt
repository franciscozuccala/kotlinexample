import kotlinx.coroutines.experimental.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

class CoroutinesExample {
    fun exampleWithLaunch(){
        // Start a coroutine
        launch(CommonPool) {
            //Delay no bloquea el hilo en el que se ejecuta, solo la coroutine
            delay(1000)
            println("Hello")
        }

        //Como esta la coroutine se ejecuta aparte, si no se espera a que termine,
        //el programa termina antes de que la coroutine lo haga
        Thread.sleep(2000) // wait for 2 seconds
    }

    fun exampleWithRunBlocking(){
        //Blockea el proceso para esperar a que termine la coroutine
        runBlocking {
            delay(1000)
            println("Hello")
        }
    }

    fun makeATestWithALotOfThreads(){
        val c = AtomicInteger()

        for (i in 1..1_000_000)
            thread(start = true) {
                c.addAndGet(i)
            }

        println(c.get())
    }

    fun makeATestWithALotOfCoroutines(){
        val c = AtomicInteger()

        for (i in 1..1_000_000)
            launch(CommonPool) {
                c.addAndGet(i)
            }

        println(c.get())
    }

    //Cada coroutine ejecuta como async me devuelve un Deferred
    //esto esta vinculado a Futures and promises https://en.wikipedia.org/wiki/Futures_and_promises
    private fun asynchronousExample(): List<Deferred<Int>> {
        //Async
        val deferred = (1..1_000_000).map { n ->
            async (CommonPool) {
                delay(1000)
                n
            }
        }
        return deferred
    }

    fun executeAsynchronous(){
        //El método sumBy, permite juntar todos los valores de las coroutines
        //para que eso ocurra correctamente, se puede pasar una suspend fun
        //para que pueda recolectar todos los valores correctamente
        runBlocking {
            val sum = asynchronousExample().sumBy {it.await()}
            println("Suma $sum")
        }
    }

    //La palabra suspend, dice que va a ser ejecutado dentro de un coroutine,
    //por lo cual nos deja utilizar otras funciones suspend, como delay
    //Representa que va puede llegar a suspender la coroutine
    suspend fun workload(n:Int): Int{
        delay(1000)
        return n
    }
}

fun main(args: Array<String>) {
    val coroutines = CoroutinesExample()
    println("Start")

    coroutines.executeAsynchronous()

    println("Stop")
}