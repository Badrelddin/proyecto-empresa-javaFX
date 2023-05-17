package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextField
import service.Empleados

class loginController {
    @FXML
    private lateinit var TFemail: TextField

    @FXML
    private lateinit var TFpassword: TextField

    @FXML

    private fun login(){

        var email = TFemail.text
        var password = TFpassword.text
        if (Empleados.login(email, password)){
            println("funca")
        }
    }
}