/**
 * ALU.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.bo
 */
package vm.bo;

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
		
		if (id == VMEspecification.ALUOP_RTYPE) {
			int funct = Util.bitSetToInt(aluControl.FUNCT);
			
			if (funct == 0) {    	//and
				System.out.println("and");
			}
			else if (funct == 1) {  // or
				System.out.println("or");
			}
			else if (funct == 2) {  //add
				System.out.println("add");
			}
			else if (funct == 6) {   //sub
				System.out.println("sub");
			}
			
				
		}
		else if (id == 0) {   // lw e sw
			System.out.println("lw e sw");
		}
		else if (id == 1) { 	// beq
			System.out.println("beq");
		}
			
//			sinais de controle
//			operação
//			000 AND
//			001 OR
//			010 add
//			110 sub
//			111 set on less than

			
	}

}
