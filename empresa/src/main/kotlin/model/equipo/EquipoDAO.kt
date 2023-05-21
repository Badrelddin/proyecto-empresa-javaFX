package model.equipo

interface EquipoDAO {

    fun getEquipos():List<Equipo>

    fun insertEquipo(Equipo:Equipo):Boolean
}