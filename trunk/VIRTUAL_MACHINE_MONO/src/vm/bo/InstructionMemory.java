/**
 * InstructionMemory.java
 * cadi
 * VM_MONOCICLO
 * vm.bo
 */
package vm.bo;

import java.util.BitSet;
import java.util.Vector;

/**
 * @author cadi
 *
 */
public class InstructionMemory {

	private Vector<String> instruction = new Vector<String>();
	

	public InstructionMemory() {
	}
	
	/**
	 * @return the instruction
	 */
	public Vector<String> getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(Vector<String> instruction) {
		this.instruction = instruction;
	}

	
	/**
	 * Adiciona instrução sempre com indice de 4 em 4
	 * @param str
	 */
	public void addInstruction(String str) {
		this.instruction.add(str);
		this.instruction.add("");
		this.instruction.add("");
		this.instruction.add("");
	}
	

	/**
	 * Le instrucao dada pelo pc e atribui aos campos seus respectivos valores
	 * @param pC
	 * @return Instruçao no endereço PC
	 */
	public Instruction readInstruction(int pC) {
		
		String str = this.instruction.get(pC);
		if (str.equals("")) {
			System.out.println("Endereço PC invalido");
			return null;
		}
		BitSet op = this.getOP(str);
		Instruction instruction = new Instruction();
		
		instruction.OP = op;
		instruction.RS = this.getRS(str);
		instruction.RT = this.getRT(str);
		
		//para R Type
		instruction.RD = this.getRD(str);
		instruction.SHAMT = this.getSHAMT(str);
		instruction.FUNCT = this.getFUNCT(str);
		
		//para constante da I
		instruction.CONST = this.getCONST(str);
		instruction.ADDRESS = this.getADDRESS(str);
		
		instruction.J_ADDRESS = this.getJADRESS(str);
		
		instruction.setStrInstruciton(str);
		
		System.out.println(str);
		
		return instruction;
		
	}

	
	
	/**
	 * Obtem endereço para instruçoes do tipo I
	 * @param str
	 * @return
	 */
	private BitSet getADDRESS(String str) {
		BitSet address = new BitSet(15);
		int index = 15;
		
		for (int i = 16; i < 32; i++) {
			if (str.charAt(i) == '0') {
				address.clear(index);
			}
			else if (str.charAt(i) == '1') {
				address.set(index);
			}
			index--;
		}
		
		return address;
	}

	
	/**
	 * Obtem o campo CONST para instruçoes do tipo I
	 * @return
	 */
	private BitSet getCONST(String str) {
		BitSet rt = new BitSet(15);
		int index = 15;
		
		for (int i = 16; i < 32; i++) {
			if (str.charAt(i) == '0') {
				rt.clear(index);
			}
			else if (str.charAt(i) == '1') {
				rt.set(index);
			}
			index--;
		}
		
		return rt;
	}
	
	
	
	/**
	 * Obtem o valor do jump para instruçoes do tipo J
	 * @param str
	 * @return
	 */
	private BitSet getJADRESS(String str) {
		BitSet rt = new BitSet(25);
		int index = 25;
		
		for (int i = 0; i < 26; i++) {
			if (str.charAt(i) == '0') {
				rt.clear(index);
			}
			else if (str.charAt(i) == '1') {
				rt.set(index);
			}
			index--;
		}
		
		return rt;
	}
	
	

	/**
	 * Obtem o campo FUNCT para instruçoes do tipo R
	 * @param str
	 * @return
	 */
	private BitSet getFUNCT(String str) {
		BitSet funct = new BitSet(5);
		funct.clear();
		int index = 5;
		
		for (int i = 26; i < 32; i++) {
			if (str.charAt(i) == '0') {
				funct.clear(index);
			}
			else if (str.charAt(i) == '1') {
				funct.set(index);
			}
			index--;
		}
		
		return funct;
	}

	/**
	 * Obtem o campo SHAMT para instruçoes do tipo R
	 * @param str
	 * @return
	 */
	private BitSet getSHAMT(String str) {
		BitSet shamt = new BitSet(4);
		int index = 4;
		
		for (int i = 21; i < 26; i++) {
			if (str.charAt(i) == '0') {
				shamt.clear(index);
			}
			else if (str.charAt(i) == '1') {
				shamt.set(index);
			}
			index--;
		}
		
		return shamt;
	}

	
	
	/**
	 * Obtem o registrador RT da instruçao
	 * @param str
	 * @return
	 */
	private BitSet getRT(String str) {
		BitSet rt = new BitSet(4);
		int index = 4;
		
		for (int i = 11; i < 16; i++) {
			if (str.charAt(i) == '0') {
				rt.clear(index);
			}
			else if (str.charAt(i) == '1') {
				rt.set(index);
			}
			index--;
		}
		
		return rt;
	}

	
	
	/**
	 * Obtem o campo RD da instruçao
	 * @param str
	 * @return
	 */
	private BitSet getRD(String str) {
		BitSet rd = new BitSet(4);
		int index = 4;
		
		for (int i = 16; i < 21; i++) {
			if (str.charAt(i) == '0') {
				rd.clear(index);
			}
			else if (str.charAt(i) == '1') {
				rd.set(index);
			}
			index--;
		}
		
		return rd;
	}

	/**
	 * Obtem o campo RS da instruçao
	 * @param str
	 * @return
	 */
	private BitSet getRS(String str) {
		BitSet rs = new BitSet(4);
		int index = 4;
		
		for (int i = 6; i < 11; i++) {
			if (str.charAt(i) == '0') {
				rs.clear(index);
			}
			else if (str.charAt(i) == '1') {
				rs.set(index);
			}
			index--;
		}
		
		return rs;
	}

	/**
	 * Obtem o OPCODE da instruçao
	 * @param str
	 * @return
	 */
	private BitSet getOP(String str) {
		BitSet op = new BitSet(5);
		int index = 5;
		
		for (int i = 0; i < 6; i++) {
			if (str.charAt(i) == '0') {
				op.clear(index);
			}
			else if (str.charAt(i) == '1') {
				op.set(index);
			}
			index--;
		}
		
		return op;
	}
	
	
}
