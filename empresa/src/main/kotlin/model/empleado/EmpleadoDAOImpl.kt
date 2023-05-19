package model.empleado

import model.ConexionDB
import model.Constantes
import model.user.User
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.Date

class EmpleadoDAOImpl : EmpleadoDAO {
    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)



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
                    Empleado(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getInt("id_user"),
                        rs.getString("fecha_nacimiento")
                    )
            }

        } catch (e: Exception) {

        } finally {
            ps?.close()
            conexion.desconectar()
            return Empleado
        }

    }

    override fun insertEmpleado(Empleado: Empleado): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query = "INSERT INTO empleado (nombre, apellidos, id_usuario, fecha_nacimiento) VALUES (?, ?, ?, ?)"
            ps = conexion.getPreparedStatement(query)

            ps?.setString(1, Empleado.nombre)
            ps?.setString(2, Empleado.apellidos)
            ps?.setInt(3, Empleado.id_user)
            val dateString = Empleado.fecha_nacimiento
            val format = SimpleDateFormat("yyyy-MM-dd")
            val parsedDate: Date = format.parse(dateString)
            val sqlDate = java.sql.Date(parsedDate.time)
            ps?.setDate(4, sqlDate)

            result = ps?.executeUpdate()

        } catch (e: Exception) {
            println(e)
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }
}