package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.Label
import model.empleado.Empleado


class empleadoController {

    var empleado = Empleado()
    var constantesController = ConstantesController()

    @FXML
    private lateinit var lbNombre: Label

    @FXML
    private lateinit var lbApellidos: Label

    @FXML
    private lateinit var lbNacimiento: Label

    fun inicializar(emple:Empleado){
        empleado = emple
        lbNombre.text = empleado.nombre
        lbApellidos.text = empleado.apellidos
        lbNacimiento.text = empleado.fecha_nacimiento
    }


    fun testEquipo(){
        try {
            constantesController.viewTraspasoEmpleadoTestEquipo("test-equipo-view.fxml", empleado)
        }catch (e:Exception){
            constantesController.alertError(e.toString())
        }
    }

    fun testLider(){
        try {
            constantesController.viewTraspasoEmpleadoTestLiderazgo("test-liderazgo-view.fxml", empleado)
        }catch (e:Exception){
            constantesController.alertError(e.toString())
        }
    }



}