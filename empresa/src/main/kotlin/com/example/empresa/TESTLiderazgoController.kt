package com.example.empresa

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import model.Ficheros.Ficheros
import model.empleado.Empleado
import model.testLider.testLider
import service.EmpleadosServicio


/*
* El test de liderazgo, es muy sencillo consiste en evaluar a tu jefe con una nota que puede ir desde el 0 al 1,
* con dos decimales. Esta nota se guarda en un fichero, donde estarán todas las notas que se han ido poniendo a los jefes,
* se separaran las notas con un guion bajo. El nombre del fichero será el identificador del empleado.
* */


class TESTLiderazgoController {


    constructor()

    @FXML
    private lateinit var pbLider: ProgressBar

    @FXML
    private lateinit var lblProgreso: Label

    @FXML
    private lateinit var lbNombreyApellidos: Label

    @FXML
    private lateinit var lbLider: Label


    var EmpleadosServicio = EmpleadosServicio()

    var escribir = Ficheros.escribirArr("/" , EmpleadosServicio.selecionarEmpleados())

    var fichero = Ficheros.leer("./")



    @FXML
    private fun btnMasPulsado() {
        pbLider.progress += 0.1
        if (pbLider.progress > 1){
            pbLider.progress= 1.0
        }
        lblProgreso.text = pbLider.progress.toString()
    }


    @FXML
    private fun btnMenosPulsado() {
        pbLider.progress -= 0.1
        if (pbLider.progress < 0){
            pbLider.progress= 0.0
        }
        lblProgreso.text = (pbLider.progress).toString()
    }

    fun enviar(){

    }

    var empleado = Empleado()

    fun inicializar(empleado: Empleado){
        this.empleado = empleado
        lbNombreyApellidos.text = empleado.ObtenerNombreyApellidos()
        lbLider.text = "test"
    }
}