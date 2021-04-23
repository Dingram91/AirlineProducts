package AirlineProducts;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexa
 */
public class FileUtils {

    /**
     * Shows a file chooser popup window and gets the user selection.
     *
     * @return
     */
    public static File showFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "png", "jpg");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        return fileChooser.getSelectedFile();
    }

}
