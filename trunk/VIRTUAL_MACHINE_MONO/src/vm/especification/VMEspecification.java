/**
 * VMEspecification.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.especification
 */
package vm.especification;

/**
 * @author cadi
 *
 */
public class VMEspecification {
	
	public static final int DATA_MEM_SIZE = 1024;
	
	public static final int R_TYPE = 0;
	
	public static final int OP_CODE_SW = 43;
	public static final int OP_CODE_LW = 35;
	public static final int OP_CODE_BNE = 5;
	public static final int OP_CODE_BEQ = 4;
	
	public static final int OP_CODE_J = 2;
	public static final int OP_CODE_JR = 6;		//verificar se eh melhor assim ou do R TYPE
	public static final int OP_CODE_JAL = 3;
	
	public static final int OP_CODE_LI = 21;
	
	public static final int EXTEND_INT = 0x00008000;
	
	public static final int ALUOP_RTYPE = 2;
	
}
