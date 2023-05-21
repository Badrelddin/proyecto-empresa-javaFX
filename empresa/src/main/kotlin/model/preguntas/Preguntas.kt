package model.preguntas

class Preguntas {
    var id = 0
    var tipo = ""

    constructor()

    constructor(id:Int, tipo:String){
        this.id = id
        this.tipo = tipo
    }

    override fun toString(): String {
        return "PreguntasDAOImpl(id=$id, tipo='$tipo')"
    }

}