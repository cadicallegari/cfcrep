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

	
	public static BitSet choise(boolean signal, BitSet bs1, BitSet bs2) {
		
		if (signal) {
			return bs1;
		}
		
		return bs2;
	}
	
}
