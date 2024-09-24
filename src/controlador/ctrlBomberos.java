/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.mdlBomberos;
import vista.Bomberos;

/**
 *
 * @author Rene Garcia
 */
public class ctrlBomberos implements MouseListener, KeyListener {
    private mdlBomberos Modelo;
    private Bomberos Vista;

    
      public ctrlBomberos(mdlBomberos modelo, Bomberos vista) {

        this.Modelo = modelo;
        this.Vista = vista;
     
       vista.btnGuardar.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        vista.txtBuscar.addMouseListener(this);
        vista.tbBomberos.addMouseListener(this);

        Modelo.Mostrar(vista.tbBomberos);
      
      }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vista.btnGuardar) {
            if (Vista.txtNombreBombero.getText().isEmpty() || Vista.txtEdadBombero.getText().isEmpty() || Vista.txtPesoBombero.getText().isEmpty() || Vista.txtCorreoBombero.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(Vista, "Debes llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo
                    Modelo.setNombre_bombero(Vista.txtNombreBombero.getText());
                    Modelo.setEdad_bombero(Integer.parseInt(Vista.txtEdadBombero.getText()));
                    Modelo.setPeso_bombero(Integer.parseInt(Vista.txtPesoBombero.getText()));
                    Modelo.setCorreo_bombero(Vista.txtCorreoBombero.getText());
                   

                    //Ejecutar el metodo 
                    Modelo.Guardar();
                    Modelo.Mostrar(Vista.tbBomberos);
                    Modelo.limpiar(Vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == Vista.btnEliminar) {
            if (Vista.txtNombreBombero.getText().isEmpty() || Vista.txtEdadBombero.getText().isEmpty() || Vista.txtPesoBombero.getText().isEmpty() || Vista.txtCorreoBombero.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(Vista, "Debes seleccionar un registro para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Modelo.Eliminar(Vista.tbBomberos);
                Modelo.Mostrar(Vista.tbBomberos);
                Modelo.limpiar(Vista);
            }
        }

        if (e.getSource() == Vista.btnActualizar) {
            if (Vista.txtNombreBombero.getText().isEmpty() || Vista.txtEdadBombero.getText().isEmpty() || Vista.txtPesoBombero.getText().isEmpty() || Vista.txtCorreoBombero.getText().isEmpty() )  {
                JOptionPane.showMessageDialog(Vista, "Debes seleccionar un registro para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    //Asignar lo de la vista al modelo al momento de darle clic a actualizar
                      Modelo.setNombre_bombero(Vista.txtNombreBombero.getText());
                    Modelo.setEdad_bombero(Integer.parseInt(Vista.txtEdadBombero.getText()));
                    Modelo.setPeso_bombero(Integer.parseInt(Vista.txtPesoBombero.getText()));
                    Modelo.setCorreo_bombero(Vista.txtCorreoBombero.getText());
                   
                    //Ejecutar el método    
                    Modelo.Actualizar(Vista.tbBomberos);
                    Modelo.Mostrar(Vista.tbBomberos);
                    Modelo.limpiar(Vista);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Vista, "La edad debe ser un número", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if (e.getSource() == Vista.btnLimpiar) {
            Modelo.limpiar(Vista);
        }

        if (e.getSource() == Vista.tbBomberos) {
            Modelo.cargarDatosTabla(Vista);
        }
        
          if (e.getSource()==Vista.btnBuscar){
             
          Modelo.Buscar(Vista.tbBomberos, Vista.txtBuscar);
                    Modelo.Mostrar(Vista.tbBomberos);
       }
     

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
