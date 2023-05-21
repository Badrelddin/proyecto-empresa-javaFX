package model.EmpleadoEquipo

import model.empleado.Empleado

interface EmpleadoEquipoDAO {

    fun getLider():Empleado
}