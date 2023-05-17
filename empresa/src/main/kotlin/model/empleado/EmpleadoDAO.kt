package model.empleado

interface EmpleadoDAO {
    fun login(email:String, password:String):Boolean
}