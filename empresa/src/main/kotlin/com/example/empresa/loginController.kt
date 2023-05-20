package com.example.empresa

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage
import service.EmpleadosServicio

class loginController {
    @FXML
    private lateinit var TFemail: TextField

    @FXML
    private lateinit var TFpassword: TextField

    @FXML
    private lateinit var lbError: Label

    @FXML

    private fun login() {
        var EempleadosServicio = EmpleadosServicio()
        var constantesController = ConstantesController()
        var email = TFemail.text
        var password = TFpassword.text

        if (EempleadosServicio.login(email, password)) {
            var empleado = EempleadosServicio.searchEmpleado(email)!!
            if (EempleadosServicio.esJefe(email)) {
                try {
                    constantesController.viewTraspasoAdmin("admin-view.fxml", empleado)

                } catch (e: Exception) {
                    constantesController.alertError(e.toString())
                }
            } else {
                try {
                    constantesController.viewTraspasoEmpleado("empleado-view.fxml", empleado)

                } catch (e: Exception) {
                    constantesController.alertError(e.toString())
                }
            }

        } else
            lbError.isVisible = true
            lbError.text = "Inicio de sesión incorrecto"
    }

    @FXML
    private fun signup() {
        var constantesController = ConstantesController()

        try {
            constantesController.view("signup-view.fxml")
        } catch (e: Exception) {
            constantesController.alertError(e.toString())
        }

    }
}