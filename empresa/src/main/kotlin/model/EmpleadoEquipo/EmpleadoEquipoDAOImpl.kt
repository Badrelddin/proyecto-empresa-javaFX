package model.EmpleadoEquipo

import model.ConexionDB
import model.Constantes
import model.empleado.Empleado

class EmpleadoEquipoDAOImpl: EmpleadoEquipoDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)

    override fun getLider(): Empleado {
        conexion.conectar()
        val query = "SELECT * FROM empleado WHERE email = ?"
        val ps = conexion.getPreparedStatement(query)

        var Empleado: Empleado? = null
        try {
            ps?.setString(1, "")
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
            return Empleado!!
        }
    }

}