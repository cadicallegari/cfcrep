/**
 * FileLoader.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.business
 */
package vm.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;

/**
 * @author cadi
 *
 */
public class FileLoader {

	public static String filePath = "";
	public static Vector<String> instruction = new Vector<String>();
	
	
	public static void load(String filePath) throws IOException {
		FileLoader.filePath = filePath;
			
		BufferedReader buf = new BufferedReader(new FileReader(FileLoader.filePath));
		
		String line = buf.readLine();
		
		while (buf.ready()) {
			line.trim();
			FileLoader.instruction.add(line);
//			FileLoader.instruction.add("");   //artificio algebrico
//			FileLoader.instruction.add("");
//			FileLoader.instruction.add("");
			line = buf.readLine();
		}
		
	}


	/**
	 * @return
	 */
	public static String chooseFile() {
        JFileChooser fC = new JFileChooser(".");
        fC.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fC.showOpenDialog(fC);
        if (result == JFileChooser.CANCEL_OPTION) {
            return "";
        }
        return fC.getSelectedFile().getAbsolutePath();
	}
	
	
}
