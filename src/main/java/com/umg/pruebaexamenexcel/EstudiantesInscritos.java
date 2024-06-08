/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.pruebaexamenexcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author javierfajardo
 */
public class EstudiantesInscritos {

    private List<Estudiantes> listaEstudiantes;

    public EstudiantesInscritos() {
        listaEstudiantes = new ArrayList<>();
    }

    public void menuInicio() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("***BIENVENIDO AL MENU DE INICIO***");
            System.out.println("Ingrese 1 si quiere inscribirse a alguna carrera universitaria");
            System.out.println("Ingrese 0 si quiere salir del menu");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1: {
                        guardadoExcel();
                        break;
                    }

                }
            } catch (Exception e) {
                opcion = 0;
            }
        } while (opcion != 0);

    }

    

    public void guardadoExcel() throws IOException {
        
         Scanner scanner = new Scanner(System.in);
        String nombreCarrera;
        String nombre;
        

        System.out.println("hola bebe");
        System.out.println("Ingrese su nombre y apellido");
        nombre = scanner.nextLine();
        System.out.println("Ingrese su carrera universitaria");
        nombreCarrera = scanner.nextLine();

        listaEstudiantes.add(new Estudiantes(nombre, nombreCarrera));
        
        
        
        String nombreReporte = System.getProperty("user.dir") + "/reporte.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet hoja = workbook.createSheet("Reporte");
      
     Row headerRow = hoja.createRow(0);
            headerRow.createCell(0).setCellValue("Nombre");
            headerRow.createCell(1).setCellValue("Carrera");
            
            

            // Llenar el Excel con los datos de los estudiantes
            int rowNum = 1;
            for (Estudiantes estudiante : listaEstudiantes) {
                Row row = hoja.createRow(rowNum++);
                row.createCell(0).setCellValue(estudiante.getNombre());
                row.createCell(1).setCellValue(estudiante.getCarrera());
                
                try (FileOutputStream fileOut = new FileOutputStream(nombreReporte)) {
                workbook.write(fileOut);
            }

            System.out.println("Datos guardados en el archivo Excel con éxito.");
        } 
    }
}
            
        
    

