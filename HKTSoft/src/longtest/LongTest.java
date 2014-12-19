/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longtest;

import java.io.File;
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
            if (CheckOS.isWindows()) {
                String str = this.getClass().getResource("").getPath().substring(5);
                File file = new File(str.substring(0, str.indexOf("bin")) + "bin\\webserver.vbs");
                String aa= file.getAbsolutePath().replaceAll("%20", " ");
                String[] processCommand = { "cmd", "/c", aa };

                Runtime.getRuntime().exec(processCommand);
            }
           // JOptionPane.showMessageDialog(null, CheckOS.isUnix());
            if (CheckOS.isUnix()) {
                String str = this.getClass().getResource("").getPath().substring(5);
                
                File file = new File(str.substring(0, str.indexOf("bin")) + "bin/pos.sh");
                Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "chmod +x pos.sh"});
                Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", file.getPath()});
            }


        } catch (Exception e) {
        }
    }

//    public File getFile(String module, String nameFile) {
//        String directory = defaultDirectory() + File.separator
//                + "HKTSoftwareEnterpriseManager" + File.separator + module;
//        if (!new File(directory).exists()) {
//            new File(directory).mkdirs();
//        }
//        String path = directory + File.separator + nameFile;;
//        return new File(path);
//    }
//
//    private String defaultDirectory() {
//        String OS = System.getProperty("os.name").toUpperCase();
//        if (OS.contains("WIN")) {
//            return System.getProperty("user.home");
//        } else if (OS.contains("MAC")) {
//            return System.getProperty("user.home") + "/Library/Application "
//                    + "Support";
//        } else if (OS.contains("NUX")) {
//            return System.getProperty("user.home");
//        }
//        return System.getProperty("user.dir");
//    }
}
