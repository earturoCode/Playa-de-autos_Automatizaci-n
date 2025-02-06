package prgs;

import formularios.Splash;
import formularios.acceso;
//import formularios.frm_menuprincipal;
import org.jvnet.substance.SubstanceLookAndFeel;

public class inicio 
{ 
    public static void main(String[] args) 
    {  
        
            acceso.setDefaultLookAndFeelDecorated(true);
            
            //configuracion del substance
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.FieldOfWheatSkin"); //GreenMagic
            SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceOrangeTheme");
            SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMetalWallWatermark");
            // termina configuracion del substance
               
               //llama al formulario splash
               new Thread(new Splash()).start();  
                          
     }
    
     public static String inicial = "si";
}
