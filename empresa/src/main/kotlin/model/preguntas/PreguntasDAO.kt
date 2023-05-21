package model.preguntas

interface PreguntasDAO {

    fun getPreguntas():List<Preguntas>

    fun getPreguntaById(Id:Int):Preguntas

    fun insertPregunta(Pregunta:String):Boolean

    fun deletePreguntaById(Id:Int):Boolean

}