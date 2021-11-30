/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectocrud;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author <Eduardo Orozco eduardo.orozco66@unach.mx>
 */
public class conexion {

    Connection con = null;

    //variables para guardar los datos de acceso a la bd
    String url = "jdbc:postgresql://localhost:5432/universidad";
    String usuario = "postgres";
    String contraseña = "Ch4software?";

    //metodo para conectar la bd, es una clase de tipo Connection 
    public Connection conectar() {
        try {
            //manejo del Driver
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("BD CONECTADA");
        } catch (Exception e) {
            //excepcion sql
            JOptionPane.showMessageDialog(null, "Error en su conexion " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }

    public static void main(String args[]) throws SQLException {
        conexion c = new conexion();
        c.conectar();
    }

}
