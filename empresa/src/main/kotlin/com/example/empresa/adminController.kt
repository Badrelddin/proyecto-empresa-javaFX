package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.Label
import model.empleado.Empleado
import service.EmpleadosServicio

class adminController {

    var empleado = Empleado()


    @FXML
    private lateinit var lbNombre: Label


    fun inicializar(emple: Empleado) {
        empleado = emple
        lbNombre.text = empleado.nombre + " " + empleado.apellidos
    }

     fun getEmpleados() {
        var EempleadosServicio = EmpleadosServicio()
        var constantesController = ConstantesController()
        var email = empleado.email

        var empleado = EempleadosServicio.searchEmpleado(email)!!

        try {
            constantesController.viewTraspasoAdminEmpleado("admin-empleados-view.fxml", empleado)

        } catch (e: Exception) {
            constantesController.alertError(e.toString())
        }

    }

}