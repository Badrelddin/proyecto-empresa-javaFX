package model.user

import model.ConexionDB
import model.Constantes
import java.sql.ResultSet

class UserDAOImpl : UserDAO {

    var conexion = ConexionDB(Constantes.url, Constantes.user, Constantes.password)
    override fun login(email: String, password: String): Boolean {
        conexion.conectar()
        val query = "SELECT * FROM users WHERE email = ? and password = ?"

        var User: User? = null
        var rs: ResultSet? = null
        var rtnBool = false

        try {
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, email)
            ps?.setString(2, password)

            rs = ps?.executeQuery()

            if (rs?.next()  == true) {
                User = User(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("password")
                )

                rtnBool = true
            }

        } catch (e: Exception) {
            println(e)
        } finally {
            return rtnBool
        }
    }
}