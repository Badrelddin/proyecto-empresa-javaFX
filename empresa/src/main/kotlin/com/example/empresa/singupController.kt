package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.DatePicker
import javafx.scene.control.TextField
import model.empleado.Empleado
import service.EmpleadosServicio

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
                var empleado = Empleado(txNombre.text, txApellidos.text, exEmail.text, datapicker.toString(), txPw.text)
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