/**
 * ALU.java
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
public class ALU {
	
	public int OPERATOR1;
	public int OPERATOR2;
	public int RESULT;
	public boolean ZERO;
	
	
	/**
	 * @param aluControl 
	 * 
	 */
	public void execute(ALUControl aluControl) {
		
		int id = Util.bitSetToInt(aluControl.ALUOp);
		
		System.out.println(id);
		
		if (id == VMEspecification.ALUOP_RTYPE) {
			int funct = Util.bitSetToInt(aluControl.FUNCT);
			
			System.out.println("funct = " + funct);
			
			//TODO criar constantes para funct
			if (funct == 36) {    	//and
				BitSet temp = Util.intToBitSet(this.OPERATOR1);
				temp.and(Util.intToBitSet(this.OPERATOR2));
				this.RESULT = Util.bitSetToInt(temp);
				
				System.out.println("and " + this.RESULT);
			}
			else if (funct == 37) {  // or
				BitSet temp = Util.intToBitSet(this.OPERATOR1);
				temp.or(Util.intToBitSet(this.OPERATOR2));
				this.RESULT = Util.bitSetToInt(temp);
				
				System.out.println("or " + this.RESULT);
			}
			else if (funct == 32) {  //add
				this.RESULT = this.OPERATOR1 + this.OPERATOR2;
				
				System.out.println("add " + this.RESULT);
			}
			else if (funct == 34) {   //sub
				this.RESULT = this.OPERATOR1 - this.OPERATOR2;
				
				System.out.println("sub " + this.RESULT);
			}
			
				
		}
		else if (id == 0) {   // lw e sw
			System.out.println("lw e sw");
		}
		else if (id == 1) { 	// beq
			this.ZERO = this.OPERATOR1 == this.OPERATOR2;
			System.out.println("beq");
		}
			

			
	}

}
