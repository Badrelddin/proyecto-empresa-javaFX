package com.example.empresa

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import model.empleado.Empleado
import model.equipo.Equipo
import model.testEquipo.testEquipo
import service.EmpleadosServicio
import service.TestEquipoServicio
import java.net.URL
import java.util.*

class TESTEquipoController {

    @FXML
    private lateinit var lbNombreyApellidos: Label

    @FXML
    private lateinit var rdBien: RadioButton

    @FXML
    private lateinit var rdRegular: RadioButton

    @FXML
    private lateinit var rdMal: RadioButton

    @FXML
    private lateinit var cbEquipo: ComboBox<Empleado>




    var empleado = Empleado()
    var constantesController = ConstantesController()
    var empleadosServicio = EmpleadosServicio()
    var testEquipoServicio = TestEquipoServicio()

    fun inicializar(empleado: Empleado) {
        this.empleado = empleado
        lbNombreyApellidos.text = empleado.ObtenerNombreyApellidos()

        try {
            println(empleado.id_equipo)

            var lista = empleadosServicio.obtenerEmpleadosPorId(empleado.id_equipo)

            lateinit var obsLista: ObservableList<Empleado>

           // obsLista.add(Empleado("Nadie", 0))

            obsLista = FXCollections.observableArrayList<Empleado>(lista)
            cbEquipo.items = obsLista

        }catch (e:Exception){

            constantesController.alertError(e.toString())
        }
    }

    fun btnSend() {

        try {
            var rtnRadio = "Regular"
            if (rdBien.isSelected){
                rtnRadio = "Bien"
            }else if (rdRegular.isSelected){
                rtnRadio = "Regular"
            }else if (rdMal.isSelected){
                rtnRadio = "Mal"
            }

            var selectCB =  cbEquipo.value.id_equipo

            println(empleado.id)

            var test = testEquipo(rtnRadio, empleado.id.toString(),selectCB.toString())

            if (testEquipoServicio.enviarDatos(test)){
                constantesController.alertSuccess("Los datos han sido enviados correctamente")
            }else{
                constantesController.alertError("No se ha podido enviar los datos")
            }

        }catch (e: Exception){
            constantesController.alertError(e.toString())
        }

    }


}