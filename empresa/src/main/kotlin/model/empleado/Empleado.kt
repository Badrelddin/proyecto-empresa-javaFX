package model.empleado

class Empleado {

    var id = 0
    var nombre = ""
    var apellidos = ""
    var email = ""
    var password = ""
    var fecha_nacimiento = ""
    var es_jefe = false
    var id_equipo = 0

    constructor()


    constructor(nombre: String, id_equipo:Int){
        this.nombre = nombre
        this.id_equipo = id_equipo
    }


    constructor(nombre:String, primer_apellido:String, email:String, password:String, fecha_nacimiento:String, es_jefe:Boolean){
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.email = email
        this.password = password
        this.fecha_nacimiento = fecha_nacimiento
        this.es_jefe = es_jefe
    }

    constructor(id:Int, nombre:String, primer_apellido:String, email:String, password:String, fecha_nacimiento:String, es_jefe:Boolean, id_equipo: Int){
        this.id = id
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.email = email
        this.password = password
        this.fecha_nacimiento = fecha_nacimiento
        this.es_jefe = es_jefe
        this.id_equipo = id_equipo
    }

    fun ObtenerNombreyApellidos():String{
        return nombre + " " + apellidos
    }

    override fun toString(): String {
        return "$nombre $apellidos"
    }

}