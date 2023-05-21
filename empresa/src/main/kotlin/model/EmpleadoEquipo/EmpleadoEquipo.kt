package model.EmpleadoEquipo

class EmpleadoEquipo {

    var id = 0
    var nombre = ""

    constructor()

    constructor(id:Int, nombre: String){
        this.id = id
        this.nombre = nombre
    }

    override fun toString(): String {
        return "EmpleadoEquipo(id=$id, nombre='$nombre')"
    }


}