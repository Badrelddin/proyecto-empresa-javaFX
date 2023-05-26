package com.example.empresa

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Modality
import javafx.stage.Stage
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
           // constantesController.viewTraspasoEmpleadoTestLiderazgo("test.fxml", empleado)
            val loader = FXMLLoader(javaClass.getResource("test.fxml"))
            val root = loader.load<Parent>()
            /*val detailController = loader.getController<TESTLiderazgoController>()

            detailController.inicializar(Empleado)*/

            val stage = Stage()
            stage.initModality(Modality.APPLICATION_MODAL)
            stage.scene = Scene(root)

            stage.showAndWait()
        }catch (e:Exception){
            println(e.toString())
            constantesController.alertError(e.toString())
        }
    }



}