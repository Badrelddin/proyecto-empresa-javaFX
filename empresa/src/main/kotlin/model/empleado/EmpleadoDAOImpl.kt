package model.empleado

import model.ConexionDB
import model.Constantes
import model.equipo.Equipo
import java.sql.PreparedStatement
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EmpleadoDAOImpl : EmpleadoDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)
    override fun login(email: String, password: String): Boolean {
        conexion.conectar()
        val query = "SELECT * FROM empleado WHERE email = ? and password = ?"
        val ps = conexion.getPreparedStatement(query)

        var Empleado: Empleado? = null

        var rtnLogin = false

        try {
            ps?.setString(1, email)
            ps?.setString(2, password)

            val rs = ps?.executeQuery()
            if (rs?.next() == true) {
                Empleado =
                    Empleado(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fecha_nacimiento"),
                        rs.getBoolean("es_jefe")
                    )
                rtnLogin = true
            }

        } catch (e: Exception) {
            println(e)
        } finally {
            return rtnLogin
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
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fecha_nacimiento"),
                        rs.getBoolean("es_jefe"),
                        rs.getInt("id_equipo")
                    )
            }

        } catch (e: Exception) {

        } finally {
            ps?.close()
            conexion.desconectar()
            return Empleado
        }

    }

    override fun getEmpleados(): List<Empleado> {
        conexion.conectar()
        val query = "SELECT * FROM empleado"
        val ps = conexion.getPreparedStatement(query)

        var Empleado: Empleado? = null
        var arrEmpleados = ArrayList<Empleado>()
        try {
            val rs = ps?.executeQuery()
            while (rs?.next() == true) {
                Empleado =
                    Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fecha_nacimiento"),
                        rs.getBoolean("es_jefe"),
                        rs.getInt("id_equipo")
                    )
                arrEmpleados.add(Empleado)
            }

        } catch (e: Exception) {

        } finally {
            ps?.close()
            conexion.desconectar()
            return arrEmpleados
        }
    }

    override fun getEmpleadosByIdEquip(id: Int): List<Empleado> {
        conexion.conectar()
        val query = "SELECT * FROM empleado where id_equipo = ?"
        val ps = conexion.getPreparedStatement(query)

        var Empleado: Empleado? = null
        var arrEmpleados = ArrayList<Empleado>()
        try {
            ps?.setInt(1,id)

            val rs = ps?.executeQuery()
            while (rs?.next() == true) {
                Empleado =
                    Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fecha_nacimiento"),
                        rs.getBoolean("es_jefe"),
                        rs.getInt("id_equipo")
                    )
                arrEmpleados.add(Empleado)
            }

        } catch (e: Exception) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
            return arrEmpleados
        }
    }
    override fun insertEmpleado(Empleado: Empleado): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query =
                "INSERT INTO empleado (nombre, apellidos, email, password, fecha_nacimiento, es_jefe) VALUES (?, ?, ?, ?, ?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, Empleado.nombre)
            ps?.setString(2, Empleado.apellidos)
            ps?.setString(3, Empleado.email)
            ps?.setString(4, Empleado.password)

            val format = SimpleDateFormat("yyyy-MM-dd")
            val parsedDate: Date = format.parse(Empleado.fecha_nacimiento)
            val sqlDate = java.sql.Date(parsedDate.time)

            ps?.setDate(5, sqlDate)

            ps?.setBoolean(6, Empleado.es_jefe)

            result = ps?.executeUpdate()

        } catch (e: SQLException) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

    override fun deleteEmpleado(id: Int): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query =
                "DELETE from EMPLEADO WHERE id = ?"
            ps = conexion.getPreparedStatement(query)

            ps?.setInt(1, id)
            result = ps?.executeUpdate()

        } catch (e: SQLException) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }


}