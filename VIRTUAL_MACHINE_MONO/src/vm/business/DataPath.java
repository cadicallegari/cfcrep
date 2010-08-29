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
		
		//unidade de controle se prepara para instruçao
		this.control.setOp(this.instruction_current.OP);
		
		//TODO calcular jump address j_address sh 2 + pc + 4
		pc4 = Adder.add(DataPath.PC, 4);
		jumpAddressExtended = this.shiftLeft2(Util.bitSetToInt(this.instruction_current.J_ADDRESS));
		jumpAddress = this.calculateJumpAddress(jumpAddressExtended, pc4);
		
		//rs e rt servem de entrada para banco de registradores
		this.registers.READ_REGISTER_1 = Util.bitSetToInt(this.instruction_current.RS);
		this.registers.READ_REGISTER_2 = Util.bitSetToInt(this.instruction_current.RT);
		
		//multiplexador descide com base no REGDST o valor de WRITE REGISTER
		wregister = MUX.choise(this.control.RegDst, 
									this.instruction_current.RT, 
									this.instruction_current.RD);
		this.registers.WRITE_REGISTER = Util.bitSetToInt(wregister);
		
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
									jumpAddressSignalExtended,
									this.registers.readData2()
									);
		this.alu.OPERATOR2 = secondOperator;

		//executa a operaçao na alu
		//TODO
		this.alu.execute(this.aluControl);
		
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
		
		end = MUX.choise(resultAnd, pc4_SignalExtended, pc4);
		
		DataPath.PC = MUX.choise(this.control.Jump, jumpAddressSignalExtended, end);
		
		//escreve ou nao no registrador de acordo com o sinal REGWRITE
		this.registers.execute(this.control.RegWrite);
		
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
