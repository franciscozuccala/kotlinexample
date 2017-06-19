//Who can use the annotation
@Target(AnnotationTarget.CLASS)
//Until how long will be living the annotation, for reflection it must be runtime
@Retention(AnnotationRetention.RUNTIME)
//Can use the same annotation on the same object, multiple times
@Repeatable
//Specified that the annotation is part of the public api
@MustBeDocumented
annotation class MyAnnotation

class HaveFunWithError{

    @Throws(Error::class)
    fun throwAnError(){
        throw Error("This is an error")
    }
}


