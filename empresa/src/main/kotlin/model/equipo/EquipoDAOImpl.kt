package model.equipo

import model.ConexionDB
import model.Constantes
import model.empleado.Empleado

class EquipoDAOImpl : EquipoDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)

    override fun getEquipos(): List<Equipo> {
        conexion.conectar()
        val query = "SELECT * FROM equipo"
        val ps = conexion.getPreparedStatement(query)

        var Equipo: Equipo? = null
        var arrEquipo = ArrayList<Equipo>()
        try {
            val rs = ps?.executeQuery()
            while (rs?.next() == true) {
                Equipo =
                    Equipo(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("miembro_del_equipo")
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
}