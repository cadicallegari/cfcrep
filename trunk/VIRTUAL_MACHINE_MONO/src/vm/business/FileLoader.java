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

import javax.swing.JFileChooser;

import vm.bo.InstructionMemory;

/**
 * @author cadi
 *
 */
public class FileLoader {

	public static String filePath = "";
//	public static InstructionMemory instruction = new InstructionMemory();
	
	
	public static InstructionMemory load(String filePath) throws IOException {
		InstructionMemory instruction = new InstructionMemory();
		FileLoader.filePath = filePath;
		
		if (filePath == null) {
			return null;
		}
		
		BufferedReader buf = new BufferedReader(new FileReader(FileLoader.filePath));
		
		String line = buf.readLine();
		
		while (buf.ready()) {
			line.trim();
			instruction.addInstruction(line);
			line = buf.readLine();
		}
		
		return instruction;
		
	}


	/**
	 * Escolher arquivo 
	 * @return retorna path do arquivo selecionado ou null
	 */
	public static String chooseFile() {
        JFileChooser fC = new JFileChooser("..");
        fC.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fC.showOpenDialog(fC);
        if (result == JFileChooser.CANCEL_OPTION) {
            return null;
        }
        return fC.getSelectedFile().getAbsolutePath();
	}
	
	
}
