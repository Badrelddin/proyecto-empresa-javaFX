package model.empleado

interface EmpleadoDAO {

    fun login(email: String, password: String):Boolean

    fun esJefe(email: String):Boolean

    fun getEmpleadoByEmail(email: String):Empleado?

    fun getEmpleados():List<Empleado>

    fun insertEmpleado(Empleado:Empleado):Boolean

    fun deleteEmpleado(id:Int):Boolean


}