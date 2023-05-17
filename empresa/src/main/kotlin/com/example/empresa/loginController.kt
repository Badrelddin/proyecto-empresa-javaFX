package com.example.empresa

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Modality
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

        var email = TFemail.text
        var password = TFpassword.text

        if (EempleadosServicio.login(email, password)) {
            if (EempleadosServicio.esJefe(email)) {
                try {
                    var constantesController = ConstantesController()
                    constantesController.view("admin-view.fxml")

                }catch (e:Exception){
                    var constantesController = ConstantesController()
                    constantesController.alert()
                }
            } else {
                try {
                    var constantesController = ConstantesController()
                    var emple = EempleadosServicio.
                    constantesController.empleado()

                }catch (e:Exception){
                    var constantesController = ConstantesController()
                    constantesController.alert()
                }
            }
        } else
            lbError.text = "Inicio de sesión incorrecto"
    }
}