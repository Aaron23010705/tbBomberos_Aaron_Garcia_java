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
        vista.tbBomberos.addMouseListener(this);

        Modelo.Mostrar(vista.tbBomberos);
        

      
      }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        boolean hayerrores = false;            

        if (e.getSource() == Vista.btnGuardar)  {
        
            
       if (Vista.txtNombreBombero.getText().isEmpty() || Vista.txtEdadBombero.getText().isEmpty() || Vista.txtPesoBombero.getText().isEmpty() || Vista.txtCorreoBombero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Vista, "Porfavor, llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                
                hayerrores = true;
       }
            
            
            if (!Vista.txtCorreoBombero.getText().contains("@") || !Vista.txtCorreoBombero.getText().contains(".com")) {
                JOptionPane.showMessageDialog(Vista,"Ingrese un correo valido ");
              hayerrores = true;
   
            }
           try {
                int edadNumerica = Integer.parseInt(Vista.txtEdadBombero.getText());
                if(edadNumerica > 100 || edadNumerica == 0){
                    JOptionPane.showMessageDialog(Vista, "Ingrese una edad valida");
                                  hayerrores = true;

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros en la edad");
                              hayerrores = true;

                
            } 
           
           try {
                int pesoNumerico = Integer.parseInt(Vista.txtPesoBombero.getText());
                if(pesoNumerico > 250 || pesoNumerico == 0){
                    JOptionPane.showMessageDialog(Vista, "Ingrese un peso valido");
                                  hayerrores = true;

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
                              hayerrores = true;

            }


            if (hayerrores == false) {
                   Modelo.setNombre_bombero(Vista.txtNombreBombero.getText());
                    Modelo.setEdad_bombero(Integer.parseInt(Vista.txtEdadBombero.getText()));
                    Modelo.setPeso_bombero(Integer.parseInt(Vista.txtPesoBombero.getText()));
                    Modelo.setCorreo_bombero(Vista.txtCorreoBombero.getText());
                    
                      Modelo.Guardar();
                    Modelo.Mostrar(Vista.tbBomberos);
                    Modelo.limpiar(Vista);
                
            } else {
                
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
            
             
       if (Vista.txtNombreBombero.getText().isEmpty() || Vista.txtEdadBombero.getText().isEmpty() || Vista.txtPesoBombero.getText().isEmpty() || Vista.txtCorreoBombero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(Vista, "Porfavor, llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                
                hayerrores = true;
       }
            
            
            if (!Vista.txtCorreoBombero.getText().contains("@") || !Vista.txtCorreoBombero.getText().contains(".com")) {
                JOptionPane.showMessageDialog(Vista,"Ingrese un correo valido ");
              hayerrores = true;
   
            }
           try {
                int edadNumerica = Integer.parseInt(Vista.txtEdadBombero.getText());
                if(edadNumerica > 100 || edadNumerica == 0){
                    JOptionPane.showMessageDialog(Vista, "Ingrese una edad valida");
                                  hayerrores = true;

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros en la edad");
                              hayerrores = true;

                
            } 
           
           try {
                int pesoNumerico = Integer.parseInt(Vista.txtPesoBombero.getText());
                if(pesoNumerico > 250 || pesoNumerico == 0){
                    JOptionPane.showMessageDialog(Vista, "Ingrese un peso valido");
                                  hayerrores = true;

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Vista, "Ingrese solo numeros");
                              hayerrores = true;

            }


            if (hayerrores == false) {
                   Modelo.setNombre_bombero(Vista.txtNombreBombero.getText());
                    Modelo.setEdad_bombero(Integer.parseInt(Vista.txtEdadBombero.getText()));
                    Modelo.setPeso_bombero(Integer.parseInt(Vista.txtPesoBombero.getText()));
                    Modelo.setCorreo_bombero(Vista.txtCorreoBombero.getText());
                    
                       Modelo.Actualizar(Vista.tbBomberos);
                    Modelo.Mostrar(Vista.tbBomberos);
                    Modelo.limpiar(Vista);
                
            } else {
                
            }
                    
               
            }
        

        if (e.getSource() == Vista.btnLimpiar) {
            Modelo.limpiar(Vista);
        }

        if (e.getSource() == Vista.tbBomberos) {
            Modelo.cargarDatosTabla(Vista);
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
