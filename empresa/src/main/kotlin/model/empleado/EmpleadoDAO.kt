package model.empleado

import model.equipo.Equipo

interface EmpleadoDAO {

    fun login(email: String, password: String):Boolean


    fun getEmpleadoByEmail(email: String):Empleado?

    fun getEmpleados():List<Empleado>

    fun insertEmpleado(Empleado:Empleado):Boolean

    fun deleteEmpleado(id:Int):Boolean

    fun getEmpleadosByIdEquip(id:Int):List<Empleado>


}