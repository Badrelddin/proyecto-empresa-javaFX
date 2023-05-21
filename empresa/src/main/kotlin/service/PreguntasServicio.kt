package service

import model.preguntas.Preguntas
import model.preguntas.PreguntasDAOImpl

class PreguntasServicio {

    var pregunta = PreguntasDAOImpl()

    fun verPreguntas():List<Preguntas>{
        return pregunta.getPreguntas()
    }

    fun verPreguntasById(Id:Int):Preguntas{
        return pregunta.getPreguntaById(Id)
    }

    fun obtenerPreguntasAleatorias(NumPreguntas:Int):List<Preguntas>{
        var preguntasEnDB=verPreguntas().size
        var rtnPreguntas = ArrayList<Preguntas>()

        for (i in 0 until NumPreguntas){
            var x = (0..preguntasEnDB-1).random()
            var getPregunta = verPreguntasById(x)

            rtnPreguntas.add(getPregunta)
        }

        return rtnPreguntas
    }
}