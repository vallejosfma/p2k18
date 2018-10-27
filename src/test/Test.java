/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.*;

/**
 *
 * @author Seba PC
 */
public class Test {
     public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int id = -1;
        Connection cn = null;
        Random r = new Random();
        double rangeMin = 4.0;
        double rangeMax = 7.0;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
         System.out.println((double)Math.round(randomValue*10)/10);
//        DecimalFormat df = new DecimalFormat("###.#");
//        String nota = df.format(Math.random()*6 + 1);
////        nota = nota.replaceAll(".",",");
//        System.out.println(nota);
         
        try {
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "portafolio", "admin");
            String usuario = "ADMIN";
            CallableStatement cst = cn.prepareCall("{call VERIFICARLOGINAPP (?,?)}");
            cst.setString(1, usuario);
            cst.registerOutParameter(2, java.sql.Types.VARCHAR);
            cst.execute();
            String basecontrasena = cst.getString(2);
            System.out.println(basecontrasena);
            
//            // Llamada al procedimiento almacenado
//            CallableStatement cst = cn.prepareCall("{call SELECTalumno1 (?,?)}");
//
//            System.out.println("\nIntroduce el ID del alumno:");
//            try {
//                id = Integer.parseInt(entrada.readLine());
//            } catch (IOException ex) {
//                System.out.println("Error...");
//            }
//
//            // Parametro 1 del procedimiento almacenado
//            cst.setInt(1, id);
//            
//            // Definimos los tipos de los parametros de salida del procedimiento almacenado
//            cst.registerOutParameter (2, java.sql.Types.VARCHAR);
//            System.out.println("asd");
//            // Ejecuta el procedimiento almacenado
//            cst.execute();
//            
//            // Se obtienen la salida del procedimineto almacenado
//            String nombre = cst.getString(2);
//            System.out.println(nombre);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
//            CallableStatement cst = cn.prepareCall("{call INSERTalumno (?,?,?,?,?,?,?,?,?,?)} ");
//            cst.setString(1, "17674072");
//            cst.setString(2,"Sebastian");
//            cst.setDate(3, null);
//            cst.setInt(4, 27);
//            cst.setInt(5, 657084);
//            cst.setInt(6, 311677);
//            cst.setString(7, "seba.32");
//            cst.setString(8, "0");
//            cst.setInt(9, 1);
//            cst.setInt(10,1);
//            cst.execute();