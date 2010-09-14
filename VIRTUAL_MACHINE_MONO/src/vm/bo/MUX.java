/**
 * MUX.java
 * cadi
 * VM_MONOCICLO
 * vm.bo
 */
package vm.bo;

import java.util.BitSet;

/**
 * @author cadi
 *
 */
public class MUX {

	/**
	 * Faz escolha entre bs1 e bs2
	 * @param signal
	 * @param bs1
	 * @param bs2
	 * @return se signal for true retorna bs1 caso contrario bs2
	 */
	public static BitSet choise(boolean signal, BitSet bs1, BitSet bs2) {
		
		if (signal) {
			return bs1;
		}
		return bs2;
	}

	
	/**
	 * Faz escolha entre op1 e op2
	 * @param signal
	 * @param op1
	 * @param op2
	 * @return se signal for true retorna op1 caso contrario op2
	 */
	public static int choise(boolean signal, int op1, int op2) {
		
		if (signal) {
			return op1;
		}
		return op2;
	}
	
}
