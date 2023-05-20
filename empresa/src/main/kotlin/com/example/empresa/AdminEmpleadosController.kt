package com.example.empresa

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import model.Constantes
import model.empleado.Empleado
import service.EmpleadosServicio
import java.net.URL
import java.time.ZoneId
import java.util.*

class AdminEmpleadosController : Initializable {

    @FXML
    private lateinit var lbNombreyApellidos: Label

    @FXML
    private lateinit var colID: TableColumn<Empleado, Int>

    @FXML
    private lateinit var colNombre: TableColumn<Empleado, String>

    @FXML
    private lateinit var colApellidos: TableColumn<Empleado, String>

    @FXML
    private lateinit var colEmail: TableColumn<Empleado, String>

    @FXML
    private lateinit var colJefe: TableColumn<Empleado, Boolean>

    @FXML
    private lateinit var colFecha: TableColumn<Empleado, String>

    @FXML
    private lateinit var tbEmpleados: TableView<Empleado>

    private lateinit var obLista: ObservableList<Empleado>
    private var empleadoServicio = EmpleadosServicio()
    var empleado = Empleado()


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        colID.setCellValueFactory { cellData ->
            SimpleObjectProperty(cellData.value.id)
        }
        colNombre.setCellValueFactory { cellData ->
            SimpleStringProperty(cellData.value.nombre)
        }
        colApellidos.setCellValueFactory { cellData ->
            SimpleStringProperty(cellData.value.apellidos)
        }
        colEmail.setCellValueFactory { cellData ->
            SimpleStringProperty(cellData.value.email)
        }
        colJefe.setCellValueFactory { cellData ->
            SimpleBooleanProperty(cellData.value.es_jefe)
        }

        colFecha.setCellValueFactory { cellData ->
            SimpleStringProperty(cellData.value.fecha_nacimiento)
        }

        obLista = FXCollections.observableArrayList()
        for (i in empleadoServicio.selecionarEmpleados()) {
            obLista.add(i)
        }
        tbEmpleados.items =
            obLista //el items de la tabla es el que necesita la conversion de String --> SimpleStringProperty para poder representarlos internamente
    }

    fun inicializar(emple: Empleado) {
        empleado = emple
        lbNombreyApellidos.text = empleado.nombre + " " + empleado.apellidos
    }


    fun btEliminar() {
        var EmpleadosServicio = EmpleadosServicio()
        var ConstantesController = ConstantesController()
        try {

            if (ConstantesController.alertPergunta("Va a eliminar un usuario de forma permanente,\n ¿Está usted seguro?")) {
                val personaSeleccionada = tbEmpleados.selectionModel.selectedItem
                if (personaSeleccionada != null) {
                    tbEmpleados.items.remove(personaSeleccionada)
                    if (EmpleadosServicio.eliminar(personaSeleccionada.id)) {
                        ConstantesController.alertSuccess("Usuario eliminado correctamente")
                    }else{
                        ConstantesController.alertError("El usuario: ${personaSeleccionada.nombre} ${personaSeleccionada.apellidos} no ha podiso ser eliminado")

                    }
                    tbEmpleados.refresh() //actualiza la tabla, en este caso no se necesita, pero por si acaso
                }

            }

        } catch (e: Exception) {
            ConstantesController.alertError(e.toString())
        }
    }

    fun btModificar() {}

    fun btAlta() {}


}