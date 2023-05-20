package service

import model.equipo.Equipo
import model.equipo.EquipoDAOImpl

class EquipoServicio {

    var equipo = EquipoDAOImpl()
    constructor()

    fun verEquipo():List<Equipo>{
        return equipo.getEquipos()
    }
}