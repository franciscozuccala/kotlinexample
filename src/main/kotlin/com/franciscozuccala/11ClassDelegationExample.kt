package com.franciscozuccala

class ClassDelegationExample : ALotOfMethods by EmptyALotOfMethods{
    override fun first() {
        TODO("not implemented")
    }
}

object EmptyALotOfMethods : ALotOfMethods{
    override fun second() {}

    override fun third() {}

    override fun fourth() {}

    override fun first() {}

}

internal interface ALotOfMethods {
    fun first()
    fun second()
    fun third()
    fun fourth()
}