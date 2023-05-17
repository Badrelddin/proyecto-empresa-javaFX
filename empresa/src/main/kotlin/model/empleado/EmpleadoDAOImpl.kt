package model.empleado

class EmpleadoDAOImpl:EmpleadoDAO {

    override fun login(email: String, password: String): Boolean {
        try {

        }catch (e:Exception){
            println(e)
        }finally {
            return true
        }
    }
}