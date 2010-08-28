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
	
	public static int PC;
	
	
	
	/**
	 * @param instruction
	 */
	public DataPath() {
		DataPath.PC = 0;
	}

	
	public void setInstructionMemory(Vector<String> instruction) {
		this.instructionMemory.setInstruction(instruction);
	}

	
	
	/**
	 * 
	 */
	public void run() {
		
//		DataPath.PC = 12;
		
		BitSet wregister;
		BitSet jumpAddress;
		int jumpAddressExtended;
		int pc4;
		int pc4_SignalExtended;
		int jumpAddressI;
		int jumpAddressSignalExtended;
		int secondOperator;
		
		//le a instruçao da memoria de instruçoes
		this.instruction_current = this.instructionMemory.readInstruction(DataPath.PC);
		//verifica se instrucao eh valida
		if (this.instruction_current == null) {
			return;
		}
		
		//unidade de controle se prepara para instruçao
		this.control.setOp(this.instruction_current.OP);
		
		//TODO calcular jump address j_address sh 2 + pc + 4
		pc4 = Adder.add(DataPath.PC, 4);
		jumpAddressExtended = this.shiftLeft2(Util.bitSetToInt(this.instruction_current.J_ADDRESS));
		jumpAddress = this.calculateJumpAddress(jumpAddressExtended, pc4);
		
		//rs e rt servem de entrada para banco de registradores
		this.registers.setReadRegister1(Util.bitSetToInt(this.instruction_current.RS));
		this.registers.setReadRegister2(Util.bitSetToInt(this.instruction_current.RT));
		
		//multiplexador descide com base no REGDST o valor de WRITE REGISTER
		wregister = MUX.choise(this.control.RegDst, 
									this.instruction_current.RT, 
									this.instruction_current.RD);
		this.registers.setWriteRegister(Util.bitSetToInt(wregister));
		
		//extende o sinal e faz o shift left de 2 do endereço da instruçao do tipo I
		jumpAddressSignalExtended = this.extensorDeSinal(Util.bitSetToInt(this.instruction_current.ADDRESS));
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
									this.registers.readData2(),
									jumpAddressSignalExtended
									);
		
		this.alu.OPERATOR2 = secondOperator;

		//executa a operaçao na alu
		this.alu.execute();
		
		
		this.dataMemory.ADDRESS = this.alu.RESULT;
		this.dataMemory.WRITEDATA = Util.intToBitSet(this.registers.readData2());
		
		
		
		//verificar escrita nos registradores e na memoria
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
		return i << 2;
	}
	
	
	private int extensorDeSinal(int end) {
		//TODO erro em potencial
		if ((end & VMEspecification.EXTEND_INT) == VMEspecification.EXTEND_INT) {
			end &= ~VMEspecification.EXTEND_INT;
			end |= VMEspecification.EXTEND_INT;
		}
		return end;
	}




	
	
}
