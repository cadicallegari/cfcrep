/**
 * Instruction.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.bo
 */
package vm.bo;

import java.util.BitSet;

/**
 * @author cadi
 *
 */
public class Instruction {
	
	//Para todos os tipos
	public BitSet OP;
	
	//Para Tipo R e I
	public BitSet RS;
	public BitSet RT;
	
	//Para Tipo R
	public BitSet RD;
	public BitSet SHAMT;
	public BitSet FUNCT;
	
	//Para Tipo I
	public BitSet CONST;
	
	//Para tipo J
	public BitSet J_ADDRESS;
	
	public Instruction() {
		
	};
	
	public Instruction(BitSet op) {
		this.OP = op;
	}
	
}
