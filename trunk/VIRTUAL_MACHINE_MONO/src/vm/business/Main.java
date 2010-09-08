/**
 * Main.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.business
 */
package vm.business;

import java.io.IOException;

/**
 * @author cadi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			String filePath = FileLoader.chooseFile();
			
			DataPath dataPath = new DataPath();
			dataPath.setInstructionMemory(FileLoader.load(filePath));
			dataPath.run();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
