package com.example.empresa

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.CheckBox
import javafx.scene.control.ComboBox
import javafx.scene.control.DatePicker
import javafx.scene.control.RadioButton
import javafx.scene.control.TextField
import javafx.scene.control.ToggleGroup
import model.empleado.Empleado
import model.equipo.Equipo
import service.EmpleadosServicio
import service.EquipoServicio
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class singupController:Initializable {

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
    private lateinit var radioNo: RadioButton

    @FXML
    private lateinit var radioSi: RadioButton

    @FXML
    private lateinit var cbEquipo: ComboBox<Equipo>

    @FXML
    private fun signup() {
        var constantesController = ConstantesController()
        var empleadosServicio = EmpleadosServicio()

        try {
            if (txPw.text == txtConfPw.text) {

                var cash_jefe = false

                if (radioSi.isSelected){
                    cash_jefe = true
                }

                println(txPw.text)
                println(cash_jefe)

                val selectedDate = datapicker.value

                if (selectedDate != null) {

                    var empleado = Empleado(
                        txNombre.text,
                        txApellidos.text,
                        exEmail.text,
                        txPw.text,
                        datapicker.value.toString(),
                        cash_jefe
                    )
                    var equipo = cbEquipo.value
                    println(equipo.prueba())

                    if (empleadosServicio.darAlta(empleado, equipo )) {
                        constantesController.alertSuccess("Registrado correctamente")
                    } else {
                        constantesController.alertError("No se ha podido dar de alta")
                    }
                } else {
                    constantesController.alertError("No se ha seleccionado ninguna fecha.")
                }
            } else {
                constantesController.alertError("La contraseña no coincide")
            }

        } catch (e: Exception) {
            constantesController.alertError(e.toString())
            println(e.toString())
        }

    }

    @FXML
    private lateinit var obsLista: ObservableList<Equipo>


    override fun initialize(location: URL?, resources: ResourceBundle?) {

        var equipo = EquipoServicio()
        var lista = equipo.verEquipo()
        obsLista = FXCollections.observableArrayList<Equipo>(lista)
        cbEquipo.items = obsLista
    }
}