package model.empleado

interface EmpleadoDAO {
    fun login(email:String, password:String):Boolean
    fun esJefe(email: String):Boolean

    fun getEmpleado(email: String):Empleado
}