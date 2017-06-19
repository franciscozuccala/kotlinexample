import com.sun.org.apache.xml.internal.dtm.ref.CoroutineManager
import kotlin.coroutines.experimental.Continuation

class CoroutinesExample {
    fun <T> async(block: suspend () -> T){

    }

    fun <R,T>(suspend R.() -> T).startCourutine(
            receiver:R,
            completition: Continuation<T>){

    }
}

fun main(args: Array<String>) {

}