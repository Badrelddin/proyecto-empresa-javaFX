package model.user

interface UserDAO {
    fun login(email:String, password:String):Boolean
}