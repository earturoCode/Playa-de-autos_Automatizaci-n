package prgs;

import formularios.acceso;
import java.sql.*;
import javax.swing.*;
//import org.jvnet.substance.SubstanceLookAndFeel;

public class conexion
{
     public static String desdeinicio = "si";
     
    //para la conexion   
    //public String user = "root";
    //public String pass = "";
    //public String bd   = "pr1_2024";  
    //public final String host = "jdbc:mysql://localhost/";
    
   public String user = acceso.vuser;
   public String pass = acceso.vpas;
   public String bd   = acceso.vbd;   
   public final String host = "jdbc:mysql://"+acceso.vhost+"/"; 
    
     //////
    
    public Connection conexion = null; //el mas importante    
    
    public Statement sentencia;
    public ResultSet resultado;
    public PreparedStatement ps;
    ////
    public conexion()// constructor
    {
        try  // todo bien if 
        {
            Class.forName("com.mysql.jdbc.Driver");//Se registra el Driver jdbc de MySQL
            conexion = DriverManager.getConnection(host+bd,user,pass);
                   
            
           if(desdeinicio.equals("si"))
             { 
                JOptionPane.showMessageDialog(null, "YA ESTAS CONECTADO  A LA BASE DE DATOS","Bienvenidos",JOptionPane.INFORMATION_MESSAGE);                        
                                  
                 desdeinicio = "no";   
               //acceso.setDefaultLookAndFeelDecorated(true);
                 
               //SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.GreenMagicSkin");//
               //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBottleGreenTheme");  
              // SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark"); 
             }                            
         
            
            
         // habilita la variable para recibir sentencias  
         // sentencia = conexion.createStatement(); 
          
       // resultado = sentencia.executeQuery("SELECT * FROM grupos");
       
          
          // while(resultado.next()==true)
         //  {
             //  System.out.print(resultado.getString("gru_id")+"-");
             //  System.out.println(resultado.getString("gru_descri"));      
               
         //  } // fin mientras
            
       //sentencia.executeUpdate("INSERT IMTO grupos(gru_id,gru_descri) VALUES(7,'pruebaconex2')");
       //sentencia.executeUpdate("DELETE FROM grupos WHERE gru_id = 6");
      //sentencia.executeUpdate("UPDATE grupos SET gru_descri = 'desdejava' WHERE gru_id = 5");

            
        }//fin todo bien
         catch (Exception e) // error de conexion else
        {
             JOptionPane.showMessageDialog(null, "Problemas con la Sintaxis SQL o Parametros de Conexion" , "Verifiquelo",JOptionPane.INFORMATION_MESSAGE);
             System.exit(0);//salir
        }
    }//fin del constructor

    public static void main(String[] args) // programa principal
    {
		new conexion();// llama al constructor
    }
 }




