package com.example.empresa

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.stage.Modality
import javafx.stage.Stage
import model.empleado.Empleado

class ConstantesController {
    constructor()

    fun alertError(error: String){
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.alertType = Alert.AlertType.ERROR // Error

        alert.contentText = error

        val buttonTypeOne = ButtonType("One")
        val buttonTypeTwo = ButtonType("Two")
        val buttonTypeCancel = ButtonType.CANCEL
        alert.buttonTypes.setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel)

        // Mostrando la alerta y procesando la respuesta
        val result = alert.showAndWait()
        if (result.get() == buttonTypeOne) {
            println("Button One clicked")
        } else if (result.get() == buttonTypeTwo) {
            println("Button Two clicked")
        } else {
            println("Dialog canceled")
        }

    }

    fun alertSuccess(error: String){
        val alert = Alert(Alert.AlertType.CONFIRMATION)
      //  alert.alertType = Alert.AlertType.INFORMATION // Error

        alert.contentText = error

        val buttonTypeClose = ButtonType.CLOSE
        alert.buttonTypes.setAll(buttonTypeClose)

        // Mostrando la alerta y procesando la respuesta
        val result = alert.showAndWait()

    }

    fun view(vista:String){
        val loader = FXMLLoader(javaClass.getResource(vista))
        val root = loader.load<Parent>()

        val stage = Stage()
        stage.scene = Scene(root)
        stage.initModality(Modality.APPLICATION_MODAL)
        //stage.show()
        stage.showAndWait()
    }

    fun empleado(emple:Empleado){
        val fxmlLoader = FXMLLoader(empleadoController::class.java.getResource("empleado-view.fxml"))

        val scene = Scene(fxmlLoader.load(), 320.0, 400.0)
        val detailController = fxmlLoader.getController<empleadoController>()
        detailController.inicializar(emple)

        var stage = Stage()
        stage.title = "Ver Datos"
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.scene = scene
        stage.showAndWait()
    }

}