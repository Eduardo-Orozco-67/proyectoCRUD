/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocrud;

import getset.variables;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author <Eduardo Orozco eduardo.orozco66@unach.mx>
 */
public class crud {

    conexion con = new conexion();
    ResultSet rs;
    variables var = new variables();
//    creacion de los metodos para la insercion de datos
//    en este caso son 5 tablas por lo tanto son 5 metodos

    //metodo que recibe como parametros lo datos a guardar
    public void insertar(String dni, String nombre, String poblacion, String direccion, String telefono, Float salario) {

        //tratamiento de excepcion sql
        try {
            //conexion
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            //sentencia sql
            String sql = "insert into camioneros(dni,nombre,poblacion,direccion,telefono,salario) values('" + dni + "','" + nombre + "','" + poblacion + "','" + direccion + "','" + telefono + "','" + salario + "');";
            st.execute(sql);
            //cerramos la coneccion
            st.close();
            conexion.close();
            //mensajes
            JOptionPane.showMessageDialog(null, "Registro exitoso", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido " + e, "mensaje", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void insertar1(String matricula, String modelo, String potencia, String tipo) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "insert into camiones(matricula,modelo,potencia,tipo) values('" + matricula + "','" + modelo + "','" + potencia + "','" + tipo + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido " + e, "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertar2(String matricula, String dni, String fecha) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "insert into camiones_camioneros(matricula,dni,fecha) values('" + matricula + "','" + dni + "','" + fecha + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido " + e, "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertar3(String CP, String nombre) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "insert into poblaciones(codigo_postal,nombre) values('" + CP + "','" + nombre + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido " + e, "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertar4(String codigopa, String dnipa, String cppa, String descpa, String destpa, String direcc_D) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "insert into paquetes(codigo,dni,codigo_postal,descripcion,destinatario,direccion_dest)"
                    + " values('" + codigopa + "','" + dnipa + "','" + cppa + "','" + descpa + "','" + destpa + "','" + direcc_D + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro fallido " + e, "mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

//    fin de los metodos para la insercion de datos
//metodos usados para la busqueda de los datos
    public void mostrar(String dni) {

        //tratamiento de excepcion sql
        try {
            //conexion a la BD
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            //sentencia sql
            String sql = "select * from camioneros where dni ='" + dni + "';";
            rs = st.executeQuery(sql);
            //condicion para la obtencion de los datos de la bd
            if (rs.next()) {
                var.setDni(rs.getString("dni"));
                var.setNombre(rs.getString("nombre"));
                var.setPoblacion(rs.getString("poblacion"));
                var.setDireccion(rs.getString("direccion"));
                var.setTelefono(rs.getString("telefono"));
                float sal = Float.valueOf(rs.getString("salario"));
                var.setSalario(sal);
                //si no encuentra algo lo pone en blanco
            } else {
                var.setDni("");
                var.setNombre("");
                var.setPoblacion("");
                var.setDireccion("");
                var.setTelefono("");
                float sal = 0;
                var.setSalario(sal);
                //mensaje de fallo
                JOptionPane.showMessageDialog(null, "No se Encontro Registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);

            }
            //cerramos conexion
            st.close();
            conexion.close();
            //mensaje final
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar1(String matricula) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "select * from camiones where matricula ='" + matricula + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setMatricula(rs.getString("matricula"));
                var.setModelo(rs.getString("modelo"));
                var.setPotencia(rs.getString("potencia"));
                var.setTipo(rs.getString("tipo"));
            } else {
                var.setMatricula("");
                var.setModelo("");
                var.setPotencia("");
                var.setTipo("");
                JOptionPane.showMessageDialog(null, "No se Encontro Registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);

            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar2(String matricula1) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "select * from camiones_camioneros where matricula ='" + matricula1 + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setMatriculacc(rs.getString("matricula"));
                var.setDnicc(rs.getString("dni"));
                var.setFechacc(rs.getString("fecha"));
            } else {
                var.setMatriculacc("");
                var.setDnicc("");
                var.setFechacc("");
                JOptionPane.showMessageDialog(null, "No se Encontro Registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);

            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar3(String cp) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "select * from poblaciones where codigo_postal ='" + cp + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setCp(rs.getString("codigo_postal"));
                var.setNombrepo(rs.getString("nombre"));
            } else {
                var.setCp("");
                var.setNombrepo("");
                JOptionPane.showMessageDialog(null, "No se Encontro Registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);

            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar4(String codigo) {

        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "select * from paquetes where codigo ='" + codigo + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                var.setCodigo(rs.getString("codigo"));
                var.setDnipa(rs.getString("dni"));
                var.setCppa(rs.getString("codigo_postal"));
                var.setDescripcion(rs.getString("descripcion"));
                var.setDestinatario(rs.getString("destinatario"));
                var.setDireccion_dest(rs.getString("direccion_dest"));
            } else {
                var.setCodigo("");
                var.setDnipa("");
                var.setCppa("");
                var.setDescripcion("");
                var.setDireccion_dest("");
                JOptionPane.showMessageDialog(null, "No se Encontro Registro", "sin registro", JOptionPane.INFORMATION_MESSAGE);

            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }

    //fin de los metodos mostrar
    //inicio de los metodos actualizar
    public void actualizar(String dni, String nombre, String poblacion, String direccion, String telefono, Float salario) {
        //taratamiento de excepcion sql
        try {
            //conexion a la BD
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            //senetencia sql para la actualizacion
            String sql = "update camioneros set dni='" + dni + "',nombre='" + nombre + "',poblacion='" + poblacion + "',direccion='" + direccion + "',"
                    + "telefono='" + telefono + "',salario='" + salario + "'where dni='" + dni + "'; ";
            st.executeUpdate(sql);
            //cerramos la coneccion
            st.close();
            conexion.close();
            //mensajes de actualizacion
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar1(String matricula, String modelo, String potencia, String tipo) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update camiones set matricula='" + matricula + "',modelo='" + modelo + "',potencia='" + potencia + "',tipo='" + tipo
                    + "'where matricula='" + matricula + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar2(String matricula, String dni, String fecha) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update camiones_camioneros set matricula='" + matricula + "',dni='" + dni + "',fecha='" + fecha
                    + "'where matricula='" + matricula + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar3(String cp, String nombre) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update poblaciones set codigo_postal='" + cp + "',nombre='" + nombre
                    + "'where codigo_postal='" + cp + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizar4(String codigo, String dni, String cp, String descr, String dest, String dir_dest) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update paquetes set codigo='" + codigo + "',dni='" + dni + "',codigo_postal='" + cp + "',descripcion='" + descr + "',"
                    + "destinatario='" + dest + "',direccion_dest='" + dir_dest + "'where codigo='" + codigo + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //fin de metodos actualizar
    //inicio de metodos eliminar
    public void eliminar(String dni) {
        //manejo de excepcion sql
        try {
            //conexion a la bd
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            //sentencia sql
            String sql = "delete from camioneros where dni='" + dni + "'; ";
            st.executeUpdate(sql);
            //cerramos la coneccion
            st.close();
            conexion.close();
            //mensajes de eliminacion
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar1(String matricula) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "delete from camiones where matricula='" + matricula + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar2(String matricula) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "delete from camiones_camioneros where matricula='" + matricula + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar3(String cp) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "delete from poblaciones where codigo_postal='" + cp + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminar4(String codigo) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "delete from paquetes where codigo='" + codigo + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
