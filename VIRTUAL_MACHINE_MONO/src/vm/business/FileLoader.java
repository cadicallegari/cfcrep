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
			
		BufferedReader buf = new BufferedReader(new FileReader(FileLoader.filePath));
		
		String line = buf.readLine();
		
		while (buf.ready()) {
			line.trim();
			//TODO fazer endereço incrementar de 4 em 4
			instruction.addInstruction(line);
			line = buf.readLine();
		}
		
		return instruction;
		
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
