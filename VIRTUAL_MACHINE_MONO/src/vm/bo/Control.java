/**
 * Control.java
 * cadi
 * VM_MONOCICLO
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
public class Control {
	
	public boolean RegDst;
	public boolean Jump;
	public boolean Branch;
	public boolean MemRead;
	public boolean MemtoReg;
	public BitSet  ALUOp = new BitSet(2);
	public boolean MemWrite;
	public boolean ALUSrc;
	public boolean RegWrite;
	
//	private BitSet op;
	private int opCode;
	
	
	
	/** 
	 * Recebe como entrada o codigo da operacao, e ajusta os sinais de controle
	 * para executa-la
	 * @param op
	 */
	public void setOp(BitSet op) {
//		this.op = op;
		this.opCode = Util.bitSetToInt(op);
		
		if (this.opCode == VMEspecification.R_TYPE) {      //R-TYPE
			this.setSignalToRType();
		}
		else if (this.opCode == VMEspecification.OP_CODE_LW) {
			this.setSignalToLW();
		}
		else if (this.opCode == VMEspecification.OP_CODE_SW) {
			this.setSignalToSW();
		}
		else if (this.opCode == VMEspecification.OP_CODE_BEQ) {
			this.setSignalToBEQ();
		}
		
	}
	
	
	
	/**
	 * 
	 */
	private void setSignalToBEQ() {
		this.ALUSrc 	= false;
		this.RegWrite 	= false;
		this.MemRead 	= false;
		this.MemWrite 	= false;
		this.Branch 	= true;
		this.ALUOp.set(0);
		this.ALUOp.clear(1);
	}
	
	
	
	/**
	 * 
	 */
	private void setSignalToSW() {
		this.MemWrite 	= true;
		this.Branch 	= false;
		this.ALUOp.clear();
//		this.ALUOp0 	= false;
//		this.ALUOp1 	= false;
		this.ALUSrc 	= true;
		this.RegWrite 	= false;
		this.MemRead 	= false;
	}
	/**
	 * 
	 */
	private void setSignalToLW() {
		this.RegDst 	= false;
		this.MemWrite 	= false;
		this.Branch 	= false;
		this.ALUOp.clear();
//		this.ALUOp0 	= false;
//		this.ALUOp1 	= false;
		this.ALUSrc 	= true;
		this.MemtoReg 	= true;
		this.RegWrite 	= true;
		this.MemRead 	= true;
	}

	
	
	/**
	 * 
	 */
	private void setSignalToRType() {
		this.RegDst 	= true;
		this.RegWrite 	= true;
		this.ALUOp.set(1);
		this.ALUOp.clear(0);
//		this.ALUOp1		= true;
//		this.ALUOp0 	= false;
		this.MemRead 	= false;
		this.MemWrite 	= false;
		this.Branch		= false;
		this.ALUSrc 	= false;
		this.MemtoReg 	= false;
	}
	
}
