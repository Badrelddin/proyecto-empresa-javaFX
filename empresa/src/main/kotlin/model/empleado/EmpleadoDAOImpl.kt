package model.empleado

import model.ConexionDB
import model.Constantes
import java.sql.PreparedStatement
import java.sql.SQLException

class EmpleadoDAOImpl : EmpleadoDAO {
    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)

    override fun login(email: String, password: String): Boolean {
        try {

        } catch (e: Exception) {
            println(e)
        } finally {
            return true
        }
    }

    override fun esJefe(email: String): Boolean {
        try {

        } catch (e: Exception) {
            println(e)
        } finally {
            return true
        }
    }

    override fun getEmpleadoByEmail(email: String): Empleado? {
        conexion.conectar()
        val query = "SELECT * FROM empleado WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)

        var Empleado: Empleado? = null
        try {
            ps?.setString(1, email)
            val rs = ps?.executeQuery()
            if (rs?.next() == true) {
                Empleado =
                    Empleado(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("fecha_nacimiento"), rs.getString("password"))
            }

        } catch (e: Exception) {

        } finally {
            ps?.close()
            conexion.desconectar()
            return Empleado
        }

    }

    override fun insertEmpleado(Empleado: Empleado): Boolean {
        var result:Int?=null
        var ps:PreparedStatement?=null

        try {
            conexion.conectar()
            val query = "INSERT INTO empleado (nombre, apellido, email, password, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)"
            ps = conexion.getPreparedStatement(query)

            ps?.setString(1, Empleado.nombre)
            ps?.setString(2, Empleado.apellidos)
            ps?.setString(3, Empleado.email)
            ps?.setString(4, Empleado.password)
            ps?.setString(5, Empleado.fecha_nacimiento)
            result = ps?.executeUpdate()

        }catch (e: SQLException){
            println(e.message)
        }finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }
}