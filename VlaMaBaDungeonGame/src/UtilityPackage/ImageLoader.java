package UtilityPackage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageLoader {
    
    private ImageLoader() {   
    }  
    
    public static BufferedImage ladeBild(String pImageName) {
        BufferedImage Bim = null;
        File File = new File("images\\"+pImageName);
        try {
            Bim = ImageIO.read(File);
        } catch (IOException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        } 
        if(StaticMethods.isNull(Bim)) {
            System.out.println(Bim+" | "+pImageName+" : ist null!");
        }
        return Bim;
    }
}
