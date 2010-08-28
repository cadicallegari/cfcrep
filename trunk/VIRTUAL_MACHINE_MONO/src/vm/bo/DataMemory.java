/**
 * DataMemory.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.bo
 */
package vm.bo;

import java.util.BitSet;

import vm.especification.VMEspecification;

/**
 * @author cadi
 *
 */
public class DataMemory {

	public int ADDRESS;
	public BitSet WRITEDATA;
	public BitSet READDATA;
	
	private BitSet[] memory = new BitSet[VMEspecification.DATA_MEM_SIZE];

	
	public DataMemory() {
		for (int i = 0; i < VMEspecification.DATA_MEM_SIZE; i++) {
			this.memory[i] = new BitSet(31);
		}
	}


	/**
	 * @param memWrite
	 * @param memRead
	 */
	public void execute(boolean memWrite, boolean memRead) {
		if (memWrite) {
			this.memory[this.ADDRESS] = this.WRITEDATA;
		}
		if (memRead) {
			this.READDATA = this.memory[this.ADDRESS];
		}
	}
	

}
