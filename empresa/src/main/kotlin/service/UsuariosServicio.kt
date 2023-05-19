package service

import model.user.UserDAOImpl

class UsuariosServicio {

    var usu = UserDAOImpl()
    fun login(email:String, password:String):Boolean{
        return usu.login(email, password)
    }

}