/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package options;

/**
 *
 * @author DarkOvs77
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class OptionsFile {

    public static ArrayList<String> readFile(String route) {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(route);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            ArrayList myData = new ArrayList();

            String lines;
            while ((lines = br.readLine()) != null) {
                myData.add(lines);
            }

            ArrayList var7 = myData;
            return var7;
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception var14) {
                var14.printStackTrace();
            }

        }

        return null;
    }

    public static String openFileManager() {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(fc);
        return new String(fc.getSelectedFile().getAbsolutePath());
    }
}
