/**
 * RegisterSet.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.bo
 */
package vm.bo;

import java.util.BitSet;

import vm.business.Util;

/**
 * @author cadi
 *
 */
public class RegisterSet {

	public int READ_REGISTER_1;
	public int READ_REGISTER_2;
	public int WRITE_REGISTER;
	public BitSet WRITE_DATA;
	
	public BitSet READ_DATA_1;
	public BitSet READ_DATA_2;
	
	private int[] content = new int[32];
	
	
	
	
	public int readData1() {
		return this.content[this.READ_REGISTER_1]; 
	}
	
	
	public int readData2() {
		return this.content[this.READ_REGISTER_2];
	}
	
	
	/**
	 * @param regWrite
	 */
	public void execute(boolean regWrite) {
		if (regWrite) {
			this.content[this.WRITE_REGISTER] = Util.bitSetToInt(this.WRITE_DATA);
		}
	}
	
}
