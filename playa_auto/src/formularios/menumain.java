
package formularios;

import formularios.contrato;
import formularios.acceso;
import formularios.registrarauto;
import formularios.registrarcli;
import formularios.registrarven;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class menumain extends javax.swing.JFrame {


    public menumain() {
       initComponents();
       this.setExtendedState(menumain.MAXIMIZED_BOTH);
       this.Lfecha.setText(acceso.fechasistema);
       this.Lusuario.setText(acceso.usunombre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel4 = new javax.swing.JLabel();
        Lfecha = new javax.swing.JLabel();
        Lusuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        CLIENTES = new javax.swing.JMenu();
        LISTARCLI = new javax.swing.JMenuItem();
        registrarcli = new javax.swing.JMenuItem();
        VENDEDORES = new javax.swing.JMenu();
        LISTARVEN = new javax.swing.JMenuItem();
        registrarven = new javax.swing.JMenuItem();
        AUTOS = new javax.swing.JMenu();
        LISTARAUT = new javax.swing.JMenuItem();
        REGISTRARAUT = new javax.swing.JMenuItem();
        CONTRATOS = new javax.swing.JMenu();
        LISTARCON = new javax.swing.JMenuItem();
        SALIR = new javax.swing.JMenu();
        SALIRCONFIR = new javax.swing.JMenuItem();
        AYUDA = new javax.swing.JMenu();
        INTERACTIVA = new javax.swing.JMenuItem();
        USUARIO_MENU = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PLAYA DE AUTOS");
        setMinimumSize(new java.awt.Dimension(70, 90));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("FECHA:");

        Lfecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lfecha.setForeground(new java.awt.Color(0, 51, 0));
        Lfecha.setText("FECHA");

        Lusuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Lusuario.setForeground(new java.awt.Color(0, 51, 0));
        Lusuario.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("USUARIO:");

        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Lfecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(Lusuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(Lfecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(Lusuario)
                .addGap(40, 40, 40))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lfecha)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(Lusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        CLIENTES.setText("CLIENTES");

        LISTARCLI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/listar.png"))); // NOI18N
        LISTARCLI.setText("LISTAR CLIENTES");
        LISTARCLI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISTARCLIActionPerformed(evt);
            }
        });
        CLIENTES.add(LISTARCLI);

        registrarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/anadir-cliente.png"))); // NOI18N
        registrarcli.setText("REGISTRAR CLIENTE");
        registrarcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarcliActionPerformed(evt);
            }
        });
        CLIENTES.add(registrarcli);

        jMenuBar1.add(CLIENTES);

        VENDEDORES.setText("VENDEDORES");

        LISTARVEN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/listar.png"))); // NOI18N
        LISTARVEN.setText("LISTAR VENDEDORES");
        LISTARVEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISTARVENActionPerformed(evt);
            }
        });
        VENDEDORES.add(LISTARVEN);

        registrarven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/agregar-vendedor.png"))); // NOI18N
        registrarven.setText("REGISTRAR VENDEDOR");
        registrarven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarvenActionPerformed(evt);
            }
        });
        VENDEDORES.add(registrarven);

        jMenuBar1.add(VENDEDORES);

        AUTOS.setText("AUTOS");

        LISTARAUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/lista-de-auto.png"))); // NOI18N
        LISTARAUT.setText("LISTAR AUTOS");
        LISTARAUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISTARAUTActionPerformed(evt);
            }
        });
        AUTOS.add(LISTARAUT);

        REGISTRARAUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/agregar-auto.png"))); // NOI18N
        REGISTRARAUT.setText("REGISTRAR AUTO");
        REGISTRARAUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTRARAUTActionPerformed(evt);
            }
        });
        AUTOS.add(REGISTRARAUT);

        jMenuBar1.add(AUTOS);

        CONTRATOS.setText("CONTRATOS");

        LISTARCON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/grabar.png"))); // NOI18N
        LISTARCON.setText("LISTAR CONTRATOS DE CLIENTES");
        LISTARCON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LISTARCONActionPerformed(evt);
            }
        });
        CONTRATOS.add(LISTARCON);

        jMenuBar1.add(CONTRATOS);

        SALIR.setText("SALIR");

        SALIRCONFIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/salida-menu.png"))); // NOI18N
        SALIRCONFIR.setText("CONFIRMAR");
        SALIRCONFIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRCONFIRActionPerformed(evt);
            }
        });
        SALIR.add(SALIRCONFIR);

        jMenuBar1.add(SALIR);

        AYUDA.setText("AYUDA");

        INTERACTIVA.setText("AYUDA INTERACTIVA");
        INTERACTIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INTERACTIVAActionPerformed(evt);
            }
        });
        AYUDA.add(INTERACTIVA);

        USUARIO_MENU.setText("MANUAL DE USUARIO");
        USUARIO_MENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USUARIO_MENUActionPerformed(evt);
            }
        });
        AYUDA.add(USUARIO_MENU);

        jMenuBar1.add(AYUDA);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LISTARAUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISTARAUTActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_LISTARAUTActionPerformed

    private void registrarcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarcliActionPerformed
        //1 = vendedor
        //2 = admin
        if(acceso.usunivel.equals("1") || acceso.usunivel.equals("2"))
        {  
           new registrarcli().setVisible(true);
           //registrarcli c = new registrarcli();
           //c.show();
        } else {  
             JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA UTILIZAR EL FORMULARIO");
       }      
        
        
    }//GEN-LAST:event_registrarcliActionPerformed

    private void registrarvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarvenActionPerformed
        //1 = vendedor
        //2 = admin
    if(acceso.usunivel.equals("2")) {
        new registrarven().setVisible(true);
    } else {
        JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA UTILIZAR EL FORMULARIO");
    }

    }//GEN-LAST:event_registrarvenActionPerformed

    private void REGISTRARAUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTRARAUTActionPerformed
        //1 = vendedor
        //2 = admin
         if(acceso.usunivel.equals("2"))
        {  
           new registrarauto().setVisible(true);
        }    
       else
       {  
             JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA UTILIZAR EL FORMULARIO");
       }
    }//GEN-LAST:event_REGISTRARAUTActionPerformed

    private void SALIRCONFIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRCONFIRActionPerformed
        dispose();
    }//GEN-LAST:event_SALIRCONFIRActionPerformed

    private void LISTARCONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISTARCONActionPerformed
        //1 = vendedor
        //2 = admin
         if(acceso.usunivel.equals("1") || acceso.usunivel.equals("2"))
        {  
            contrato con = new contrato();
            con.show();
        }    
       else
       {  
             JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA UTILIZAR EL FORMULARIO");
       }
    }//GEN-LAST:event_LISTARCONActionPerformed

    private void LISTARCLIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISTARCLIActionPerformed
        //1 = usuario normal
        //2 = vendedor
        //3 = admin
         if(acceso.usunivel.equals("3"))
        {  
           new registrarven().setVisible(true);
        }    
       else
       {  
             JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA UTILIZAR EL FORMULARIO");
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_LISTARCLIActionPerformed

    private void LISTARVENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LISTARVENActionPerformed
        //1 = usuario normal
        //2 = vendedor
        //3 = admin
         if(acceso.usunivel.equals("3"))
        {  
           new registrarven().setVisible(true);
        }    
       else
       {  
             JOptionPane.showMessageDialog(null, "NO TIENE PRIVILEGIOS PARA UTILIZAR EL FORMULARIO");
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_LISTARVENActionPerformed

    private void USUARIO_MENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USUARIO_MENUActionPerformed
                // llamar a la ayuda
        String  path = new String("C:\\Users\\Arturo Fernández\\Desktop\\PROYECTO TERMINADO\\playa_auto\\src\\ayuda\\playa.pdf");
        try
        {
                  //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + path);
                  
                  Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
        }
        catch (IOException ex)
        {
                 Logger.getLogger(menumain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_USUARIO_MENUActionPerformed

    private void INTERACTIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INTERACTIVAActionPerformed
        // llamar a la ayuda
        String  path = new String("C:\\Users\\Arturo Fernández\\Desktop\\PROYECTO TERMINADO\\playa_auto\\src\\ayuda\\playa.chm");
        try
        {
                  //Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + path);
                  
                  Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
        }
        catch (IOException ex)
        {
                 Logger.getLogger(menumain.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_INTERACTIVAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menumain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menumain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AUTOS;
    private javax.swing.JMenu AYUDA;
    private javax.swing.JMenu CLIENTES;
    private javax.swing.JMenu CONTRATOS;
    private javax.swing.JMenuItem INTERACTIVA;
    private javax.swing.JMenuItem LISTARAUT;
    private javax.swing.JMenuItem LISTARCLI;
    private javax.swing.JMenuItem LISTARCON;
    private javax.swing.JMenuItem LISTARVEN;
    private javax.swing.JLabel Lfecha;
    private javax.swing.JLabel Lusuario;
    private javax.swing.JMenuItem REGISTRARAUT;
    private javax.swing.JMenu SALIR;
    private javax.swing.JMenuItem SALIRCONFIR;
    private javax.swing.JMenuItem USUARIO_MENU;
    private javax.swing.JMenu VENDEDORES;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem registrarcli;
    private javax.swing.JMenuItem registrarven;
    // End of variables declaration//GEN-END:variables
}
