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
		else if (this.opCode == VMEspecification.OP_CODE_J) {
			this.setSignalToJ();
		}
		else if (this.opCode == VMEspecification.OP_CODE_JR) {
			this.setSignalToJR();
		}
		else if (this.opCode == VMEspecification.OP_CODE_JAL) {
			this.setSignalToJAL();
		}
		else if (this.opCode == VMEspecification.OP_CODE_LI) {
			this.setSignalToLI();
		}
		//TODO Aqui adiciona as instruçoes
	}
	
	
	
	/**
	 * 
	 */
	private void setSignalToLI() {
		this.ALUSrc 	= true;
		this.RegWrite 	= true;
		this.RegDst 	= false;
		this.MemWrite 	= false;
		this.Branch 	= false;
		this.MemtoReg 	= false;
		this.MemRead 	= false;
		this.ALUOp.clear();
	}



	/**
	 * 
	 */
	private void setSignalToJAL() {
		// TODO Auto-generated method stub
		System.out.println("jal");
	}



	/**
	 * 
	 */
	private void setSignalToJR() {
		// TODO Auto-generated method stub
		System.out.println("jr");
	}



	/**
	 * 
	 */
	private void setSignalToJ() {
		this.RegDst 	= false;
		this.Jump		= true;
		this.Branch 	= true;
		this.MemRead 	= false;
		this.MemtoReg 	= false;
		this.ALUOp.clear();
		this.MemWrite 	= false;
		this.ALUSrc 	= false;
		this.RegWrite 	= false;
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
