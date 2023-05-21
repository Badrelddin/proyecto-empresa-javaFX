package model.testEquipo

import model.ConexionDB
import model.Constantes
import java.sql.PreparedStatement
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*

class testEquipoDAOImpl:testEquipoDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)

    override fun insertTest(datos: testEquipo): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query =
                "INSERT INTO testequipo (respuesta1, id_empleado, sobra) VALUES (?, ?, ?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, datos.respuesta1)
            ps?.setString(2, datos.respuesta2)
            ps?.setString(3, datos.sobra)

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