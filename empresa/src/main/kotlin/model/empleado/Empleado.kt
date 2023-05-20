package model.empleado

class Empleado {

    var id = 0
    var nombre = ""
    var apellidos = ""
    var email = ""
    var password = ""
    var fecha_nacimiento = ""
    var es_jefe = false

    constructor()

    constructor(nombre:String, primer_apellido:String, email:String, password:String, fecha_nacimiento:String, es_jefe:Boolean){
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.email = email
        this.password = password
        this.fecha_nacimiento = fecha_nacimiento
        this.es_jefe = es_jefe
    }
    constructor(id:Int, nombre:String, primer_apellido:String, email:String, password:String, fecha_nacimiento:String, es_jefe:Boolean){
        this.id = id
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.email = email
        this.password = password
        this.fecha_nacimiento = fecha_nacimiento
        this.es_jefe = es_jefe
    }

    override fun toString(): String {
        return "Empleado(nombre='$nombre', apellidos='$apellidos', email='$email', password='$password', fecha_nacimiento='$fecha_nacimiento')"
    }

}