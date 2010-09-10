/**
 * Teste.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.test
 */
package vm.test;

import java.util.BitSet;

import vm.business.Util;

/**
 * @author cadi
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BitSet b = new BitSet(31);
		b.set(5);
		int s = 0;
		s = Util.bitSetToInt(b);
		System.out.println(s);
		
	}

}
