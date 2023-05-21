package service

import model.testEquipo.testEquipo
import model.testEquipo.testEquipoDAOImpl

class TestEquipoServicio {
    constructor()

    var testEquipo = testEquipoDAOImpl()


    fun enviarDatos(datos:testEquipo):Boolean{
        return testEquipo.insertTest(datos)
    }

}