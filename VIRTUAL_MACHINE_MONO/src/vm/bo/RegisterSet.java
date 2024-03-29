/**
 * RegisterSet.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.bo
 */
package vm.bo;

import java.util.BitSet;

import vm.business.Util;
import vm.especification.VMEspecification;

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
	
	
	
	/**
	 * Retorna o valor do registrador com o endereço dado por READ REGISTER 1
	 * @return valor contido no registrador com o endereço dado por READ_REGISTER_1
	 */
	public int readData1() {
		return this.content[this.READ_REGISTER_1]; 
	}
	
	
	/**
	 * Retorna o valor do registrador com o endereço dado por READ REGISTER 2
	 * @return valor contido no registrador com o endereço dado por READ_REGISTER_2
	 */
	public int readData2() {
		return this.content[this.READ_REGISTER_2];
	}
	
	
	/**
	 * Retorna o valor do registrador com o endereço dado por i
	 * @return valor contido no registrador dado por i
	 */
	public int get(int i) {
		return this.content[i];
	}
	
	
	
	/**
	 * Se RegWrite for true escreve no registrador posiçao WRITE_REGISTER
	 * o conteudo de WRITE_DATA
	 * @param regWrite
	 */
	public void execute(boolean regWrite) {
		if (regWrite) {
			int i = Util.bitSetToInt(this.WRITE_DATA);
			this.content[this.WRITE_REGISTER] = i;
		}
	}


	/**
	 * @param pc4
	 */
	public void setRA(int pc4) {
		this.content[VMEspecification.REG_RA] = pc4;
	}

	public int getRA(int pc4) {
		return this.content[VMEspecification.REG_RA];
	}


	/**
	 * @param rs
	 * @return valor contido no registrador dado rs
	 */
	public Integer readRegister(BitSet rs) {
		return new Integer(this.content[Util.bitSetToInt(rs)]);
	}
}
