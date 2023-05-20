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

    fun alertPergunta(Message:String):Boolean{
        val alert = Alert(Alert.AlertType.WARNING)

        alert.contentText = Message

        val buttonTypeConfirm = ButtonType.YES
        val buttonTypeCancel = ButtonType.NO
        alert.buttonTypes.setAll(buttonTypeConfirm,buttonTypeCancel)

        val result = alert.showAndWait()
        var rtnPregunta = false
        if (result.get() == buttonTypeConfirm) {
            rtnPregunta = true
        } else if (result.get() == buttonTypeCancel) {
            rtnPregunta = false
        }
        return rtnPregunta
    }

    fun alertError(error: String){
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.alertType = Alert.AlertType.ERROR // Error

        alert.contentText = error

        val buttonTypeCancel = ButtonType.CLOSE
        alert.buttonTypes.setAll(buttonTypeCancel)

        // Mostrando la alerta y procesando la respuesta
        val result = alert.showAndWait()

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
        stage.showAndWait()
    }

    fun viewTraspasoAdmin(View:String, Empleado:Empleado){
        val loader = FXMLLoader(javaClass.getResource(View))
        val root = loader.load<Parent>()
        val detailController = loader.getController<adminController>()

        detailController.inicializar(Empleado)

        val stage = Stage()
        stage.scene = Scene(root)
        stage.title = "Panel de administración"
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.showAndWait()

    }
    fun viewTraspasoAdminEmpleado(View:String, Empleado:Empleado){
        val loader = FXMLLoader(javaClass.getResource(View))
        val root = loader.load<Parent>()
        val detailController = loader.getController<AdminEmpleadosController>()

        detailController.inicializar(Empleado)

        val stage = Stage()
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.scene = Scene(root)

        stage.showAndWait()
    }

    fun viewTraspasoEmpleado(View:String, Empleado:Empleado){
        val loader = FXMLLoader(javaClass.getResource(View))
        val root = loader.load<Parent>()
        val detailController = loader.getController<empleadoController>()

        detailController.inicializar(Empleado)

        val stage = Stage()
        stage.initModality(Modality.APPLICATION_MODAL)
        stage.scene = Scene(root)

        stage.showAndWait()
    }


}