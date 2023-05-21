package model.Ficheros

import model.empleado.Empleado
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.ArrayList
import java.util.Collections
import java.util.Objects

class Ficheros {

    constructor()


    companion object {

        fun escribir(ruta: String, ObjetoString: String) {
            try {
                val fw = FileWriter(ruta, true)
                val salida = PrintWriter(fw)
                salida.println(ObjetoString)
                salida.close()
            } catch (e: Exception) {
                println(e.toString())
            }

        }

        fun escribirArr(ruta: String, arrList: List<Empleado>) {
            try {
                val fw = FileWriter(ruta, true)
                val salida = PrintWriter(fw)

                for (i in arrList) {
                    salida.println(i)
                }

                salida.close()
            } catch (e: Exception) {
                println(e.toString())
            }

        }


        fun leer(rutaConFichero: String) {
            val file = File(rutaConFichero)

            // Leer el archivo línea por línea utilizando readLines
            val lineas = file.readLines()

            var rtnEmpleados = ArrayList<Empleado>()

            for (linea in lineas) {
                println(linea)
            }

        }

    }


    /*
    fun recuperar(ruta: String){
        var solucion = ArrayList<Autores>()
        var id:Int
        var nombre:String
        var nacionalidad:String

        val file = File(ruta)

        val lineas = file.readLines()
        for (linea in lineas) {
            id = linea.substringAfter("id=").substringBefore(",").toInt()
            nombre = linea.substringAfter("nombre='").substringBeforeLast("', n")
            nacionalidad = linea.substringAfter("nacionalidad='").substringBeforeLast("'")

            var autor = Autores(id,nombre,nacionalidad)
            solucion.add(autor)
        }
        return solucion
    }*/
}