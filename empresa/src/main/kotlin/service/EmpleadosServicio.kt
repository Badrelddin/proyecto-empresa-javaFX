package service

import model.empleado.Empleado
import model.empleado.EmpleadoDAOImpl
import model.equipo.Equipo
import model.equipo.EquipoDAOImpl
import model.user.UserDAOImpl

class EmpleadosServicio {
    constructor()
    var emple = EmpleadoDAOImpl()

    fun eliminar(Id:Int):Boolean{
        return emple.deleteEmpleado(Id)
    }

    fun selecionarEmpleados():List<Empleado>{
        return emple.getEmpleados()
    }
    fun login(email:String, password:String):Boolean{
        return emple.login(email, password)
    }

    fun esJefe(email:String):Boolean{
        return emple.getEmpleadoByEmail(email)!!.es_jefe
    }

    fun searchEmpleado(email:String): Empleado? {
        return emple.getEmpleadoByEmail(email)
    }

    fun darAlta(empleado: Empleado, equipo: Equipo):Boolean{

        //REFACTORIZAR EN SERVICIO
        var equipoDAOImpl = EquipoDAOImpl()
        equipoDAOImpl.insertEquipo(equipo)
        return (emple.insertEmpleado(empleado))

    }


    fun obtenerEmpleadosPorId(Id: Int):List<Empleado>{
        return emple.getEmpleadosByIdEquip(Id)
    }




}