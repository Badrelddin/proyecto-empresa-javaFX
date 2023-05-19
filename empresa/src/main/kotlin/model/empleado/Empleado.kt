package model.empleado

class Empleado {

    var nombre = ""
    var apellidos = ""
    var id_user = 0
    var fecha_nacimiento = ""



    constructor()

    constructor(nombre:String, primer_apellido:String, fecha_nacimiento:String){
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.fecha_nacimiento = fecha_nacimiento


    }
    constructor(nombre:String, primer_apellido:String, id_user:Int, fecha_nacimiento:String){
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.id_user = id_user
        this.fecha_nacimiento = fecha_nacimiento


    }

    override fun toString(): String {
        return "Empleado(nombre='$nombre', apellidos='$apellidos', id_user=$id_user, fecha_nacimiento='$fecha_nacimiento')"
    }

}