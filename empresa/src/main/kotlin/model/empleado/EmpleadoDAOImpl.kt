package model.empleado

import model.ConexionDB
import model.Constantes
import java.sql.PreparedStatement

class EmpleadoDAOImpl:EmpleadoDAO {
    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)

    override fun login(email: String, password: String): Boolean {
        try {

        }catch (e:Exception){
            println(e)
        }finally {
            return true
        }
    }

    override fun esJefe(email: String): Boolean {
        try {

        }catch (e:Exception){
            println(e)
        }finally {
            return true
        }
    }

    override fun getEmpleado(email: String): Empleado {
        conexion.conectar()
        var result:Int?=null
        var ps: PreparedStatement? = null
        var correcto:Int = 1

        val query = "select * from empleados where empleado = ?;"
        ps = conexion.getPreparedStatement(query)
        try {
            ps?.setInt(1, a.id)
            ps?.setString(2, a.nombre)
            ps?.setInt(3, a.edad)
            val utilDate = a.fechaNacimiento
            val sqlDate = java.sql.Date.valueOf(utilDate)
            ps?.setDate(4, sqlDate)
            ps?.setBoolean(5, a.matriculado)
            result = ps?.executeUpdate()
        }catch (e:Exception){
            println("no Se puede insertar ${a.nombre}")
            correcto = 0
        }
        ps?.close()
        conexion.desconectar()

    }
}