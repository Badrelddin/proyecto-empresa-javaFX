package service

import model.empleado.Empleado
import model.empleado.EmpleadoDAOImpl

class EmpleadosServicio {
    constructor()
    var emple = EmpleadoDAOImpl()

    fun login(email:String, password:String):Boolean{
        return emple.login(email, password)
    }

    fun esJefe(email:String):Boolean{
        return emple.esJefe(email)
    }

    fun searchEmpleado(): Empleado {
        return emple.
    }

}