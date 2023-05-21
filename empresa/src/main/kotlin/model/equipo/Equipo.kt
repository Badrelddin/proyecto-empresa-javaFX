package model.equipo

class Equipo {

    var id = 0
    var nombre = ""
    var miembro_del_equipo = ""

    constructor()

    constructor(id:Int, nombre:String, miembro_del_equipo:String ){
        this.id = id
        this.nombre = nombre
        this.miembro_del_equipo = miembro_del_equipo
    }


    fun prueba():String{
        return "Equipo(id=$id, nombre='$nombre', miembro_del_equipo='$miembro_del_equipo')"

    }

    override fun toString(): String {
        return "$nombre"
    }

}