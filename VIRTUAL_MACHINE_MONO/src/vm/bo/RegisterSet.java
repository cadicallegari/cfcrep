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

	private int readRegister1;
	private int readRegister2;
	private int writeRegister;
	private BitSet writeData;
	
	private BitSet readData1;
	private BitSet readData2;
	
	private int[] content = new int[32];
	
	/**
	 * @return the readRegister1
	 */
	public int getReadRegister1() {
		return readRegister1;
	}
	/**
	 * @param readRegister1 the readRegister1 to set
	 */
	public void setReadRegister1(int readRegister1) {
		this.readRegister1 = readRegister1;
	}
	/**
	 * @return the readRegister2
	 */
	public int getReadRegister2() {
		return readRegister2;
	}
	/**
	 * @param readRegister2 the readRegister2 to set
	 */
	public void setReadRegister2(int readRegister2) {
		this.readRegister2 = readRegister2;
	}
	/**
	 * @return the writeRegister
	 */
	public int getWriteRegister() {
		return writeRegister;
	}
	/**
	 * @param writeRegister the writeRegister to set
	 */
	public void setWriteRegister(int writeRegister) {
		this.writeRegister = writeRegister;
	}
	/**
	 * @return the writeData
	 */
	public BitSet getWriteData() {
		return writeData;
	}
	/**
	 * @param writeData the writeData to set
	 */
	public void setWriteData(BitSet writeData) {
		this.writeData = writeData;
	}
	/**
	 * @return the readData1
	 */
	public BitSet getReadData1() {
		return readData1;
	}
	/**
	 * @param readData1 the readData1 to set
	 */
	public void setReadData1(BitSet readData1) {
		this.readData1 = readData1;
	}
	/**
	 * @return the readData2
	 */
	public BitSet getReadData2() {
		return readData2;
	}
	/**
	 * @param readData2 the readData2 to set
	 */
	public void setReadData2(BitSet readData2) {
		this.readData2 = readData2;
	}
	
	
	
	public int readData1() {
		return this.content[this.readRegister1]; 
	}
	
	
	public int readData2() {
		return this.content[this.readRegister2];
	}
	/**
	 * @param regWrite
	 */
	public void execute(boolean regWrite) {
		if (regWrite) {
			this.content[this.writeRegister] = Util.bitSetToInt(writeData);
		}
	}
	
}
