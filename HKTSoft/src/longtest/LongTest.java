/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author longnt
 */
public class LongTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LongTest l = new LongTest();
        l.run();
    }

    public void run() {
        try {
            File file = new File(readData() + "\\server\\bin\\webserver.vbs");
            
            String cmdarray[] = new String[]{"cmd", "/c",  file.getAbsolutePath()};
            
            Runtime.getRuntime().exec(cmdarray);

//            File f1 = new File(readData() + "\\server\\bin\\pos.bat");
//
//            
//            String cmdarray[] = new String[]{"cmd", "/c",  f1.getAbsolutePath()};
//            Runtime.getRuntime().exec(cmdarray);
        } catch (Exception e) {
        }
    }

    private String readData() {
        try {
            FileInputStream fi = new FileInputStream(getFile("Database", "setup").getAbsoluteFile());
            ObjectInputStream of = new ObjectInputStream(fi);
            String str = of.readObject().toString();
            of.close();
            return str;
        } catch (Exception e) {
            return "";

        }

    }

    public File getFile(String module, String nameFile) {
        String directory = defaultDirectory() + File.separator
                + "HKTSoftwareEnterpriseManager" + File.separator + module;
        if (!new File(directory).exists()) {
            new File(directory).mkdirs();
        }
        String path = directory + File.separator + nameFile;;
        return new File(path);
    }

    private String defaultDirectory() {
        String OS = System.getProperty("os.name").toUpperCase();
        if (OS.contains("WIN")) {
            return System.getProperty("user.home");
        } else if (OS.contains("MAC")) {
            return System.getProperty("user.home") + "/Library/Application "
                    + "Support";
        } else if (OS.contains("NUX")) {
            return System.getProperty("user.home");
        }
        return System.getProperty("user.dir");
    }
}
