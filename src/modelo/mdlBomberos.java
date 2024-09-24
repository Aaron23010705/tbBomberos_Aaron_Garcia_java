/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.Bomberos;

/**
 *
 * @author Rene Garcia
 */
public class mdlBomberos {

    
     private String UUID_bombero;    
    private String Nombre_bombero;
    private int Edad_bombero;
    private int Peso_bombero;
   private String Correo_bombero;

    public String getUUID_bombero() {
        return UUID_bombero;
    }

    public void setUUID_bombero(String UUID_bombero) {
        this.UUID_bombero = UUID_bombero;
    }

    public String getNombre_bombero() {
        return Nombre_bombero;
    }

    public void setNombre_bombero(String Nombre_bombero) {
        this.Nombre_bombero = Nombre_bombero;
    }

    public int getEdad_bombero() {
        return Edad_bombero;
    }

    public void setEdad_bombero(int Edad_bombero) {
        this.Edad_bombero = Edad_bombero;
    }
public int getPeso_bombero() {
        return Peso_bombero;
    }

    public void setPeso_bombero(int Peso_bombero) {
        this.Peso_bombero = Peso_bombero;
    }
   

    public String getCorreo_bombero() {
        return Correo_bombero;
    }

    public void setCorreo_bombero(String Correo_bombero) {
        this.Correo_bombero = Correo_bombero;
    }
    
   
     public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Variable que contiene la Query a ejecutar
            String sql = "Insert into tbBomberos (UUID_bombero, nombre_bombero, edad_bombero, peso_bombero, correo_bombero) values (?,?,?,?,?)";
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            //Establecer valores de la consulta SQL
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, getNombre_bombero());
            pstmt.setInt(3, getEdad_bombero());
            pstmt.setInt(4, getPeso_bombero());
            pstmt.setString(5, getCorreo_bombero());
      
            //Ejecutar la consulta
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }

    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"UUID_bombero", "nombre_bombero", "edad_bombero", "peso_bombero", "correo_bombero"});
        try {
            //Consulta a ejecutar
            String query = "SELECT * FROM tbBomberos";
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery(query);
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_bombero"), 
                    rs.getString("nombre_bombero"), 
                    rs.getString("edad_bombero"), 
                    rs.getString("peso_bombero"),
                rs.getString("correo_bombero")
          
                });
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }

    public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada

        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            String sql = "Delete from tbBomberos where UUID_bombero = ?";
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }

    public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();

            try {
                //Ejecutamos la Query
                String sql = "Update tbBomberos set nombre_bombero = ? , edad_bombero = ?, peso_bombero = ?, correo_bombero = ? where UUID_bombero = ?";
                PreparedStatement updateUser = conexion.prepareStatement(sql);

                   updateUser.setString(1, getNombre_bombero());
            updateUser.setInt(2, getEdad_bombero());
            updateUser.setInt(3, getPeso_bombero());
            updateUser.setString(4, getCorreo_bombero());
             updateUser.setString(5, miUUId);

                updateUser.executeUpdate();

            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }

    public void Buscar(JTable tabla, JTextField miTextField) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"UUID_bombero", "nombre_bombero", "edad_bombero", "peso_bombero", "correo_bombero"});
        try {
            String sql = "SELECT * FROM tbBomberos WHERE nombre_bombero LIKE ? || '%'";
            PreparedStatement buscarBombero = conexion.prepareStatement(sql);
            buscarBombero.setString(1, miTextField.getText());
            ResultSet rs = buscarBombero.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{ rs.getString("nombre_bombero"), rs.getString("edad_bombero"), rs.getString("peso_bombero"), rs.getString("correo_bombero")});
            }

            
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo de buscar " + e);
        }
    }

    public void limpiar(Bomberos Vista) {
        Vista.txtNombreBombero.setText("");
        Vista.txtEdadBombero.setText("");
        Vista.txtPesoBombero.setText("");
                Vista.txtCorreoBombero.setText("");

    }

    public void cargarDatosTabla(Bomberos Vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = Vista.tbBomberos.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_bombero = Vista.tbBomberos.getValueAt(filaSeleccionada, 0).toString();
            String Nombre = Vista.tbBomberos.getValueAt(filaSeleccionada, 1).toString();
            String Edad = Vista.tbBomberos.getValueAt(filaSeleccionada, 2).toString();
            String Peso = Vista.tbBomberos.getValueAt(filaSeleccionada, 3).toString();
            String Correo = Vista.tbBomberos.getValueAt(filaSeleccionada, 3).toString();


            // Establece los valores en los campos de texto
            Vista.txtNombreBombero.setText(Nombre);
            Vista.txtEdadBombero.setText(Edad);
            Vista.txtPesoBombero.setText(Peso);
            Vista.txtCorreoBombero.setText(Correo);

        }
    }

}



