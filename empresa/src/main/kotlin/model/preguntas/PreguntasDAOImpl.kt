package model.preguntas

import model.ConexionDB
import model.Constantes
import model.equipo.Equipo
import java.sql.PreparedStatement

class PreguntasDAOImpl : PreguntasDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)
    override fun getPreguntas(): List<Preguntas> {
        conexion.conectar()
        val query = "SELECT * FROM preguntas"
        val ps = conexion.getPreparedStatement(query)

        var Preguntas: Preguntas? = null
        var arrPreguntas = ArrayList<Preguntas>()
        try {
            val rs = ps?.executeQuery()
            while (rs?.next() == true) {
                Preguntas =
                    Preguntas(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                    )
                arrPreguntas.add(Preguntas)
            }

        } catch (e: Exception) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
            return arrPreguntas
        }
    }

    override fun getPreguntaById(Id: Int): Preguntas {
        conexion.conectar()
        val query = "SELECT * FROM preguntas where id = ?"
        val ps = conexion.getPreparedStatement(query)

        var Preguntas: Preguntas? = null
        try {
            ps?.setInt(1, Id)
            val rs = ps?.executeQuery()
            if (rs?.next() == true) {
                Preguntas =
                    Preguntas(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                    )
            }

        } catch (e: Exception) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
            return Preguntas!!
        }
    }

    override fun insertPregunta(Pregunta: String): Boolean {
        var ps: PreparedStatement? = null
        var result: Int? = null

        try {
            conexion.conectar()
            val query = "INSERT INTO empleado (tipo) VALUES (?)"
            ps = conexion.getPreparedStatement(query)
            ps?.setString(1, Pregunta)

            result = ps?.executeUpdate()

        } catch (e: Exception) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
            return result == 1
        }
    }

    override fun deletePreguntaById(Id: Int): Boolean {
        var result: Int? = null
        var ps: PreparedStatement? = null

        try {
            conexion.conectar()
            val query =
                "DELETE FROM preguntas WHERE id = ?"
            ps = conexion.getPreparedStatement(query)

            ps?.setInt(1, Id)
            result = ps?.executeUpdate()

        } catch (e: Exception) {
            println(e.toString())
        } finally {
            ps?.close()
            conexion.desconectar()
        }
        return result == 1
    }

}