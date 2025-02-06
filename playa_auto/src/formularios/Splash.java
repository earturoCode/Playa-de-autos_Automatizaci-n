/******************************************************************************/
/*****************************CONTRESPACE**************************************/
/******************TUTORIAL SPLASH SCREEN by CONTRE17**************************/
/******************************************************************************/
package formularios;


import formularios.acceso;
import java.util.logging.Level;
import java.util.logging.Logger;
import prgs.Hilo;
//import prgs.conexion;


public class Splash extends javax.swing.JFrame implements Runnable {

    int num = 0;
    Thread t;

    public Splash() {
        initComponents();
    }

    public void Llena_Barra() {
        if (Barra.getValue() <= 100) {
            num += 5;//Valor con el que se va llenar el ProgressBar. Se llenará de 3 en 3
            //Le podemos dar un valor mas alto para que se llene mas rapido o un valor mas bajo
            //para que se llene mas lento
            Barra.setValue(num);
            Barra.setStringPainted(true);
        } else {
            Barra.setValue(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barra = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BIENVENIDO--PLAYA DE AUTO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playa_auto/Images/auto-splassh-unscreen.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Hilo hl = new Hilo(this);
        hl.start();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Barra;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void run() 
    {    
       
            try {    
                
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                try {
                    t.sleep(5000);//Tiempo que deseamos que se muestre nuestro Splash: 6000 milisegundos = 6 segundos
                } catch (InterruptedException ex) {
                    Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Debemos ajustarlo bien para que nuestro Splash desaparezaca justo cuando el ProgressBar
                //acabe de llenarse.
                this.dispose();
                
                
                // menuprincipal p = new menuprincipal();
                acceso p = new acceso();
                p.setLocationRelativeTo(null);
                p.setVisible(true);
                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
       
               
    }
}
