package model.empleado

interface EmpleadoDAO {

    fun esJefe(email: String):Boolean

    fun getEmpleadoByEmail(email: String):Empleado?

    fun insertEmpleado(Empleado:Empleado):Boolean
}