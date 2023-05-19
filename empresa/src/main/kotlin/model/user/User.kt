package model.user

class User {

    var id = 0
    var email = ""
    var password = ""


    constructor()

    constructor(id:Int, email:String, password: String ){
        this.id = id
        this.email = email
        this.password = password
    }

    override fun toString(): String {
        return "User(id=$id, email='$email', password='$password')"
    }


}