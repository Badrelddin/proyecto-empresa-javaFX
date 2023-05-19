package com.example.empresa

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import javafx.stage.Modality
import javafx.stage.Stage
import model.empleado.Empleado
import service.EmpleadosServicio
import java.text.SimpleDateFormat
import javafx.application.Platform

class singupController {

    @FXML
    private lateinit var txApellidos: TextField

    @FXML
    private lateinit var txNombre: TextField

    @FXML
    private lateinit var exEmail: TextField

    @FXML
    private lateinit var txPw: TextField

    @FXML
    private lateinit var txtConfPw: TextField

    @FXML
    private lateinit var datapicker: DatePicker


    @FXML
    private fun signup() {
        var constantesController = ConstantesController()
        var empleadosServicio = EmpleadosServicio()

        try {
            if (txPw.text == txtConfPw.text) {
                val selectedDate = datapicker.value
                val format = SimpleDateFormat("yyyy-MM-dd")
                val dateString = format.format(java.sql.Date.valueOf(selectedDate))
                var empleado = Empleado(txNombre.text, txApellidos.text,dateString)
                if (empleadosServicio.darAlta(empleado)) {
                    constantesController.alertSuccess("Registrado correctamente")

                }
                else{
                    constantesController.alertError("No se ha podido dar de alta")
                }
            }else{
                constantesController.alertError("La contraseña no coincide")
            }

        } catch (e: Exception) {
            constantesController.alertError(e.toString())
        }
    }
}