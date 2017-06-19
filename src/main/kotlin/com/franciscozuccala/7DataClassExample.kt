import com.fasterxml.jackson.annotation.JsonProperty

class DataClassExample {
    val dat = DataClass("Pepe",13)

    fun modifyDat(){
        //Data class overrides to String
        dat.toString()

        //Data class overrides equals to compare values
        dat == DataClass("Pepe",13)

        //Data class implements copy method
        val myNewDat = dat.copy(name = "hola", age = 24)
    }
}

//Must have a constructor with at least one parameter
data class DataClass(val name:String, val age:Int, @JsonProperty("common_field") val commonField: String="" )

@MyAnnotation
data class DataByDefault(val name:String ="")