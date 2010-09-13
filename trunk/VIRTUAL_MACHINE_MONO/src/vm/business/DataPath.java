/**
 * DataPath.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.business
 */
package vm.business;

import java.util.BitSet;
import java.util.Vector;

import vm.bo.ALU;
import vm.bo.ALUControl;
import vm.bo.Adder;
import vm.bo.Control;
import vm.bo.DataMemory;
import vm.bo.Instruction;
import vm.bo.InstructionMemory;
import vm.bo.MUX;
import vm.bo.RegisterSet;
import vm.especification.VMEspecification;

/**
 * @author cadi
 *
 */
public class DataPath {

	private InstructionMemory instructionMemory = new InstructionMemory();
	private Instruction instruction_current = null;
	private Control control = new Control();
	private DataMemory dataMemory = new DataMemory();
	private RegisterSet  registers = new RegisterSet();
	private ALUControl aluControl = new ALUControl();
	private ALU alu = new ALU();
	
	public static Integer PC;
	
	
	
	/**
	 * @param instruction
	 */
	public DataPath() {
		DataPath.PC = 0;
	}

	
	public void setInstructionMemory(InstructionMemory instructionMemory) {
		this.instructionMemory = instructionMemory;
	}

	
	
	/**
	 * 
	 */
	public void run() {
		
		BitSet wregister;			//temporaria para guardar a escolha do registrador de destino
		BitSet jumpAddress;			//temporaria para guardar o endereço de desvio end + pc + 4 
		BitSet writeData;			//guarda dado a ser escrito no banco de registradores
		int jumpAddressExtended;	//guarda valor do endereço da instruçao com shift left de 2
		int pc4;					//guarda o valor de pc + 4
		int pc4_SignalExtended;		//guarda valor da soma de pc+4 com o endereço com sh de 2
		int jumpAddressSignalExtended; //guarda valor de desvio da instruçao com o sinal estendido para 32 bits
		int jumpAddressI;			//guarda valor de desvio com sinal estendido e sh de 2
		int secondOperator;			//guarda valor da entrada do sengundo operador da ALU
		int end;
		boolean resultAnd;
		
		//le a instruçao da memoria de instruçoes
		this.instruction_current = this.instructionMemory.readInstruction(DataPath.PC);
		//verifica se instrucao eh valida
		if (this.instruction_current == null) {
			return;
		}
		
		//unidade de controle se prepara para executar a instruçao
		this.control.setOp(this.instruction_current.OP);
		
		//TODO calcular jump address j_address sh 2 + pc + 4 POSSIVELMENTE ERRADO
		pc4 = Adder.add(DataPath.PC, 4);
		jumpAddressExtended = this.shiftLeft2(Util.bitSetToInt(this.instruction_current.J_ADDRESS));
		System.out.println(Util.bitSetToInt(this.instruction_current.J_ADDRESS) + " endereco " + jumpAddressExtended);
		jumpAddress = this.calculateJumpAddress(jumpAddressExtended, pc4);
		System.out.println(Util.bitSetToInt(jumpAddress));
		
		//rs e rt servem de entrada para banco de registradores
		this.registers.READ_REGISTER_1 = Util.bitSetToInt(this.instruction_current.RS);
		this.registers.READ_REGISTER_2 = Util.bitSetToInt(this.instruction_current.RT);
		
		//multiplexador descide com base no REGDST o valor de WRITE REGISTER
		wregister = MUX.choise(this.control.RegDst, 
									this.instruction_current.RD, 
									this.instruction_current.RT);
		this.registers.WRITE_REGISTER = Util.bitSetToInt(wregister);
		
		//extende o sinal e faz o shift left de 2 do endereço da instruçao do tipo I
		jumpAddressSignalExtended = Util.bitSetToInt(this.signalExtend(this.instruction_current.ADDRESS));
		jumpAddressI = this.shiftLeft2(jumpAddressSignalExtended);
		
		//soma pc + 4 com endereco com o sinal estendido
		pc4_SignalExtended = Adder.add(pc4, jumpAddressSignalExtended);
		
		//alimenta as entradas da ALU CONTROL
		this.aluControl.FUNCT = this.instruction_current.FUNCT;
		this.aluControl.ALUOp = this.control.ALUOp;
		
		//alimenta entradas da ULA para executar operaçoes
		this.alu.OPERATOR1 = this.registers.readData1();
		
		//descide qual o segundo operador da ULA
		secondOperator = MUX.choise(this.control.ALUSrc,
									jumpAddressSignalExtended,
									this.registers.readData2()
									);
		this.alu.OPERATOR2 = secondOperator;

		//executa a operaçao na alu
		this.alu.execute(this.aluControl);
		
		//para contornar o problema da SW com o endereço da memoria invalido
		if (Util.bitSetToInt(this.instruction_current.OP) == VMEspecification.OP_CODE_SW) {
			this.alu.RESULT = this.registers.READ_REGISTER_2;
		}
		
		this.dataMemory.ADDRESS = this.alu.RESULT;
		this.dataMemory.WRITEDATA = Util.intToBitSet(this.registers.readData2());
		
		//de acordo com os sinais faz as operaçoes na memoria
		this.dataMemory.execute(this.control.MemWrite, this.control.MemRead);
		
		//escolhe o a entrada do write data
		writeData = MUX.choise(this.control.MemtoReg,
								this.dataMemory.READDATA,
								Util.intToBitSet(this.alu.RESULT)
								);
		this.registers.WRITE_DATA = writeData;

		//porta and
		resultAnd = this.control.Branch && this.alu.ZERO;
		
		//primeiro multiplexador do endereço
		end = MUX.choise(resultAnd, pc4_SignalExtended, pc4);
		
		//segundo multiplexador do endereço
		DataPath.PC = MUX.choise(this.control.Jump, jumpAddressSignalExtended, end);
		
		//escreve ou nao no registrador de acordo com o sinal REGWRITE
		this.registers.execute(this.control.RegWrite);
		
		System.out.println(alu.RESULT);
	}

	
	
	
	

	/**
	 * @param bitSetToInt
	 * @return
	 */
	private BitSet signalExtend(BitSet b) {
		BitSet ret = new BitSet(31);
		
		if (b.get(15)) {
			ret.set(0, ret.size());
		}
		else {
			ret.clear();
		}

		for (int i = 0; i < 15; i++) {
			ret.set(i, b.get(i));
		}
		
		return ret;
	}


	/**
	 * @param jumpAddressExtended
	 * @param pc4
	 * @return
	 */
	private BitSet calculateJumpAddress(int jumpAddressExtended, int pc4) {
		//TODO erro em potencial
		BitSet end = Util.intToBitSet(jumpAddressExtended + pc4);
		return end;
	}


	/**
	 * @param i
	 * @return
	 */
	private int shiftLeft2(int i) {
		return i * 4;
	}
	

	
	public String getCurrentInstruction() {
		return this.instruction_current.getStrInstruciton();
	}
	
	public String getRegDst() {
		return Util.booleanToString(this.control.RegDst);
	}
	
	public String getJump() {
		return Util.booleanToString(this.control.Jump);
	}
	
	public String getBranch() {
		return Util.booleanToString(this.control.Branch);
	}
	
	public String getMemRead() {
		return Util.booleanToString(this.control.MemRead);
	}
	
	public String getMemtoReg() {
		return Util.booleanToString(this.control.MemtoReg);
	}
	
	public String getALUOp() {
		String str = "";
		
		str = str.concat(Util.booleanToString(this.control.ALUOp.get(0)));
		str = str.concat(Util.booleanToString(this.control.ALUOp.get(1)));
		
		return str;
	}
	
	public String getMemWrite() {
		return Util.booleanToString(this.control.MemWrite);
	}
	
	public String getALUSrc() {
		return Util.booleanToString(this.control.ALUSrc);
	}
	
	public String getRegWrite() {
		return Util.booleanToString(this.control.RegWrite);
	}
	
	public String getZero() {
		return Util.booleanToString(this.alu.ZERO);
	}


	/**
	 * @return
	 */
	public RegisterSet getRegisterSet() {
		return this.registers;
	}


	/**
	 * @return
	 */
	public DataMemory getDataMemory() {
		return this.dataMemory;
	}
	
	
	
	
//	private int extensorDeSinal(int end) {
//		//TODO erro em potencial
//		if ((end & VMEspecification.EXTEND_INT) == VMEspecification.EXTEND_INT) {
//			end &= ~VMEspecification.EXTEND_INT;
//			end |= VMEspecification.EXTEND_INT;
//		}
//		return end;
//	}




	
	
}