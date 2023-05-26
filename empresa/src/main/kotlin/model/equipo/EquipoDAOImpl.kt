package model.equipo

import model.ConexionDB
import model.Constantes
import model.empleado.Empleado
import java.sql.PreparedStatement
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EquipoDAOImpl : EquipoDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)

    override fun getEquipos(): List<Equipo> {
        conexion.conectar()
        val query = "SELECT distinct nombre FROM equipo"
        val ps = conexion.getPreparedStatement(query)

        var Equipo: Equipo? = null
        var arrEquipo = ArrayList<Equipo>()
        try {
            val rs = ps?.executeQuery()
            while (rs?.next() == true) {
                Equipo =
                    Equipo(
                        rs.getString("nombre")
                    )
                arrEquipo.add(Equipo)
            }

        } catch (e: Exception) {

        } finally {
            ps?.close()
            conexion.desconectar()
            return arrEquipo
        }
    }

    override fun insertEquipo(Equipo: Equipo): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query =
                "INSERT INTO equipo (nombre, miembro_del_equipo) VALUES (?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, Equipo.nombre)
            ps?.setString(2, Equipo.miembro_del_equipo)

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