package com.franciscozuccala

//Sirven para tener una restriccion de herarquías, son como los enuns, pero sin ser singletones
// y pueden tener estado
sealed class Expr

data class Const(val number: Double): Expr()

data class Sum(val value: Expr, val value2: Expr): Expr()

object NotANumber: Expr()

//If id add another class, the when will be broken because
//it does not cover all
//class Another():Expr()

enum class MyEnum(val value:String){
    A("a"),B("b"),C("c");

    fun sayHi(): String{
        return value
    }
}

fun main(args: Array<String>) {

    MyEnum.A.sayHi()


    fun eval(expr: Expr):Double = when(expr){
        is Const -> expr.number
        is Sum-> eval(expr.value) + eval(expr.value2)
        NotANumber -> Double.NaN
    }
}

