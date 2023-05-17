package service

import model.empleado.EmpleadoDAOImpl

class EmpleadosServicio {



    companion object{
    var emple = EmpleadoDAOImpl()

    fun login(email:String, password:String):Boolean{
        return emple.login(email, password)
    }
    }
}