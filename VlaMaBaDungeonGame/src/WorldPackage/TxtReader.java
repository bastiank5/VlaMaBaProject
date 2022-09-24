package WorldPackage;
//Liest World Text Dateien und fügt sie in ein Array ein

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TxtReader {

    private static Scanner derScanner;

    public static int[][] readTxt(File pFile) {
        File file = pFile;
        int[][] map = new int[10][10];
        try {
            derScanner = new Scanner(new FileReader(file));
            for (int y = 0; y < map[0].length; y++) {
                for (int x = 0; x < map.length; x++) {
                    map[x][y] = derScanner.nextInt();
                }
            }
            derScanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    private TxtReader() {
    }
}
