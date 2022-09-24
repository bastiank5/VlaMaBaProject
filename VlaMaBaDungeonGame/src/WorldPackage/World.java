package WorldPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class World {

    public static void main(String[] args) {
        System.out.println("Hello Monkey!");

        File World = new File("WorldDateien\\World.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(World));
            int x = 0;
            while (x < 10) {
                writer.write("Test" + x);
                writer.newLine();
                x++;
            }
            x = 0;
            writer.close();

            Scanner scanner = new Scanner(new FileReader(World));
            BufferedReader reader = new BufferedReader(new FileReader(World));
            while (x < 10) {
                System.out.println(scanner.nextLine());
                x++;
            }
            scanner.close();
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
