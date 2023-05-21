package model.testEquipo

class testEquipo {

    var id = 0
    var respuesta1 = ""
    var respuesta2 = ""
    var sobra = ""

    constructor()

    constructor(respuesta1: String, respuesta2: String, sobra: String) {
        this.respuesta1 = respuesta1
        this.respuesta2 = respuesta2
        this.sobra = sobra

    }

    override fun toString(): String {
        return "testEquipo(id=$id, respuesta1='$respuesta1', respuesta2='$respuesta2', sobra='$sobra')"
    }


}