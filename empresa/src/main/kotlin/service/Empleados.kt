package service

import model.empleado.EmpleadoDAOImpl

class Empleados {



    companion object{
    var emple = EmpleadoDAOImpl()

    fun login(email:String, password:String):Boolean{
        return emple.login(email, password)
    }
    }
}