package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.Label
import model.empleado.Empleado

class empleadoController {

    var empleado = Empleado()

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


}