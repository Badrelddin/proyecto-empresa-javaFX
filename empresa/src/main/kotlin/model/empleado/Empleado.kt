package model.empleado

class Empleado {

    var nombre = ""
    var apellidos = ""
    var email = ""
    var fecha_nacimiento = ""
    var password = ""


    constructor()

    constructor(nombre:String, primer_apellido:String, email:String, fecha_nacimiento:String, password:String){
        this.nombre = nombre
        this.apellidos = primer_apellido
        this.email = email
        this.fecha_nacimiento = fecha_nacimiento
        this.password = password

    }

    override fun toString(): String {
        return "Empleado(nombre='$nombre', apellidos='$apellidos', email='$email', fecha_nacimiento='$fecha_nacimiento', password='$password')"
    }


}