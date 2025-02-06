package formularios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prgs.conexion;

public class usuarios extends javax.swing.JFrame implements ActionListener {
    conexion conn = new conexion();
    conexion miconexion =new conexion();
    String operacion; // Variable para controlar la operaciones (agregar, editar, borrar)
    String[] datosAnteriores; // Array para almacenar los datos antes de la edicion
    boolean codigoCargado = false; // verificar codigo

    public usuarios() {
        initComponents();
       
      
        setTitle("Usuarios");
        // Desactivar campos de texto y limpiarlos
        deshabilitarCamposTexto();
        limpiarCamposTexto();
        // Desactivar botones Grabar y Cancelar
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton1.addActionListener(this); // Agregar
        jButton2.addActionListener(this); // Editar
        jButton3.addActionListener(this); // Borrar
        jButton4.addActionListener(this); // Grabar
        jButton5.addActionListener(this); // Cancelar
        jButton6.addActionListener(this); // Salir
    }

    
    private void deshabilitarCamposTexto() {
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
         jTextField6.setEnabled(false);
    }


    private void limpiarCamposTexto() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText(""); 
        jTextField6.setText("");
    }

    // Método para habilitar campos de texto
    private void habilitarCamposTexto() {
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        jTextField6.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) { // Botón Agregar
            operacion = "agregar";
            habilitarCamposTexto(); 
            limpiarCamposTexto();
            obtenerUltimoCodigo(); //ultimo codigo de cli_id
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(true); // Activar botón Grabar
            jButton5.setEnabled(true); // Activar botón Cancelar
        
            } else if (e.getSource() == jButton2) { // Botón Editar
    if (!codigoCargado) { // Si el código no está cargado
        operacion = "editar";
        jTextField1.setEnabled(true);
        jTextField1.requestFocus();
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton5.setEnabled(true); // Activar botón Cancelar
        limpiarCamposTexto(); // Limpiar campos de texto
        codigoCargado = true; // Marcar que el código está cargado
    } else {
        String codigo = jTextField1.getText();
        if (!codigo.isEmpty()) {
            //verificar codigo en la bd
            String[] datosCliente = obtenerDatosUsuario(codigo);
            if (datosCliente != null) {
                jTextField2.setText(datosCliente[1]);
                jTextField3.setText(datosCliente[2]); 
                jTextField4.setText(datosCliente[3]); 
                jTextField5.setText(datosCliente[4]); 
                jTextField6.setText(datosCliente[5]); 
               
                habilitarCamposTexto(); // Habilitar campos de texto para edición
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                
                jButton4.setEnabled(true);
                jButton5.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún registro con ese código.", "Error", JOptionPane.ERROR_MESSAGE);
                 jTextField1.requestFocus(); 
            }
        }
    }
} else if (e.getSource() == jButton3) { // Botón Borrar
    if (!codigoCargado) { // Verificar si el codigo no esta cargado
        operacion = "borrar"; // cambiar estado
        jTextField1.setEnabled(true); // Habilitar el campo de texto para que el usuario pueda ingresar el código
        jTextField1.requestFocus(); // Establecer el foco en el campo de texto
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton5.setEnabled(true);
        limpiarCamposTexto(); // Limpiar campos de texto
        codigoCargado = true; // Marcar que el codigo esta cargado
    } else {
        String codigo = jTextField1.getText(); // Obtener el código del cliente del campo de texto
        if (!codigo.isEmpty()) { // Verificar si se ingresó un código
            String[] datosCliente = obtenerDatosUsuario(codigo);
            if (datosCliente != null) { // Verificar si se encontraron datos para el cliente
                jTextField2.setText(datosCliente[1]); // Nombre
                jTextField3.setText(datosCliente[2]); // Apellido
                jTextField4.setText(datosCliente[3]); // Dirección
                jTextField5.setText(datosCliente[4]); // Correo
                jTextField6.setText(datosCliente[5]); // Teléfono
                
                
                // Preguntar al usuario si desea borrar el registro
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea borrar el registro?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) { // Si el usuario elige sí
                    if (borrarUsuario(codigo)) {
                        JOptionPane.showMessageDialog(null, "El registro se ha borrado exitosamente.", "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
                        limpiarCamposTexto(); // Limpiar campos de texto después del borrado
                        jTextField1.setEnabled(false); // Deshabilitar el campo de texto después de borrar
                        jButton1.setEnabled(true); // Reactivar el botón Agregar
                        jButton2.setEnabled(true); // Reactivar el botón Editar
                        jButton4.setEnabled(false); // Desactivar el botón Grabar
                        jButton5.setEnabled(false); // Desactivar el botón Cancelar
                        jButton3.setEnabled(true); // Reactivar el botón Borrar
                        codigoCargado = false; // Reiniciar la variable de código cargado
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al intentar borrar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    jButton5.setEnabled(true); // Activar el botón Cancelar si el usuario elige no borrar
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún registro con ese código.", "Error", JOptionPane.ERROR_MESSAGE);
                 jTextField1.requestFocus(); 
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



        } else if (e.getSource() == jButton4) { // Botón Grabar
            grabarDatos(); // Llamar al método para grabar datos
            deshabilitarCamposTexto();
            limpiarCamposTexto();
            jButton1.setEnabled(true); // Activar botón Agregar
            jButton2.setEnabled(true); // Activar botón Editar
            jButton3.setEnabled(true); // Activar botón Borrar
            jButton4.setEnabled(false); // Desactivar botón Grabar
            jButton5.setEnabled(true); // activar botón Cancelar
            codigoCargado = false; // Reiniciar la variable de código cargado
        } else if (e.getSource() == jButton5) { // Botón Cancelar
            int option = JOptionPane.showConfirmDialog(null, "¿Desea cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
            jButton5.setEnabled(true); // activar botón Cancelar
            if (option == JOptionPane.YES_OPTION) {
                deshabilitarCamposTexto(); // Deshabilitar campos de texto
                limpiarCamposTexto(); // Limpiar campos de texto
                jButton1.setEnabled(true); // Activar botón Agregar
                jButton2.setEnabled(true); // Activar botón Editar
                jButton3.setEnabled(true); // Activar botón Borrar
                jButton4.setEnabled(false); // Desactivar botón Grabar
                jButton5.setEnabled(false); // Desactivar botón Cancelar
                codigoCargado = false; // Reiniciar la variable de código cargado
            }
        } else if (e.getSource() == jButton6) { // Botón Salir
            int option = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }
private boolean borrarUsuario(String codigo) {
        try {
            conn.sentencia = conn.conexion.createStatement();
            // Ejecutar la sentencia SQL para borrar el usuario
            int filasAfectadas = conn.sentencia.executeUpdate("DELETE FROM usuarios WHERE usu_id = " + codigo);
            if (filasAfectadas > 0) {
                // Si se han afectado filas (es decir, si el usuario se ha borrado correctamente)
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; // Si no se pudo borrar el usuario, retorna false
    }


   private String[] obtenerDatosUsuario(String codigo) {
        try {
            conn.sentencia = conn.conexion.createStatement();
            conn.resultado = conn.sentencia.executeQuery("SELECT * FROM usuarios WHERE usu_id = " + codigo);
            if (conn.resultado.next()) {
                String[] datos = new String[6];
                datos[0] = conn.resultado.getString("usu_id");
                datos[1] = conn.resultado.getString("usu_nombre");
                datos[2] = conn.resultado.getString("usu_login");
                datos[3] = conn.resultado.getString("usu_pass");
                datos[4] = conn.resultado.getString("usu_nivel");
                datos[5] = conn.resultado.getString("usu_estado");
                return datos;
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
   private void grabarDatos() {
        try {
            conn.sentencia = conn.conexion.createStatement();

            if (operacion.equals("agregar")) {
                conn.sentencia.executeUpdate("INSERT INTO usuarios(usu_id, usu_nombre, usu_login, usu_pass, usu_nivel, usu_estado) VALUES('" + jTextField1.getText() + "','" + jTextField2.getText() + "','" + jTextField3.getText() + "','" + cifrarMD5(jTextField4.getText()) + "','" + jTextField5.getText() + "','" + jTextField6.getText() + "')");

                JOptionPane.showMessageDialog(null, "El registro se ha insertado satisfactoriamente.", "CONFIRMACION", JOptionPane.INFORMATION_MESSAGE);
            }

            if (operacion.equals("editar")) {
                conn.sentencia.executeUpdate("UPDATE usuarios SET usu_nombre = '" + jTextField2.getText() + "', usu_login = '" + jTextField3.getText() + "', usu_pass = '" + cifrarMD5(jTextField4.getText()) + "', usu_nivel = '" + jTextField5.getText() + "', usu_estado = '" + jTextField6.getText() + "' WHERE usu_id =" + jTextField1.getText());

                JOptionPane.showMessageDialog(null, "El registro se ha modificado satisfactoriamente.", "CONFIRMACION", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void obtenerUltimoCodigo() {
        try {
            conn.sentencia = conn.conexion.createStatement();
            conn.resultado = conn.sentencia.executeQuery("SELECT MAX(usu_id) FROM usuarios");
            if (conn.resultado.next()) {
                int ultimoCodigo = conn.resultado.getInt(1);
                jTextField1.setText(String.valueOf(ultimoCodigo + 1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/anadir-cliente.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/editar.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/borrar.png"))); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/grabar.png"))); // NOI18N
        jButton4.setText("Grabar");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/cancelar.png"))); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/salida.png"))); // NOI18N
        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel1.setText("Codigo:");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Login:");

        jLabel4.setText("Contraseña:");

        jLabel5.setText("Nivel:");

        jLabel6.setText("Estado:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Registro para nuevos usuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
     
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
       // validar solo letras
       int k = (int) evt.getKeyChar();
        if (k > 47 && k < 58) ///del 0 al 9
	{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();///el sonido del error
            evt.consume();////mantiene el pulsor al presionar espacio
            JOptionPane.showMessageDialog(null,"No puede Ingresar Numeros");
            
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
     
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.jTextField2.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
     //  buscar_codigo();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != evt.VK_BACK_SPACE) {
            evt.consume(); // Ignorar el carácter
            JOptionPane.showMessageDialog(null, "Solo se permiten números en el Nivel", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped
 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                     
     private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }        
     private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
            
      
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                usuarios frame = new usuarios();
                frame.setLocationRelativeTo(null); // Centrar en la pantalla
                frame.setVisible(true);
            }
        });
    }
{
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
private String cifrarMD5(String input) {
        try {
            // Obtener la instancia de MessageDigest con el algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Calcular el hash de la cadena de entrada
            byte[] messageDigest = md.digest(input.getBytes());
            // Convertir a hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error al cifrar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
