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

	public static final int ALUOP_RTYPE = 2;
	
	public static final int OP_CODE_J = 2;
	public static final int OP_CODE_JR = 8;		//verificar se eh melhor assim ou do R TYPE
	public static final int OP_CODE_JAL = 3;
	
	public static final int OP_CODE_LI = 21;
	
	public static final int REG_BASE_T_INIT  = 8;
	public static final int REG_BASE_T_FINAL = 16;
	
	public static final int REG_BASE_S_INIT  = 16;
	public static final int REG_BASE_S_FINAL = 24;
	
	public static final int REG_RA = 31;
}
