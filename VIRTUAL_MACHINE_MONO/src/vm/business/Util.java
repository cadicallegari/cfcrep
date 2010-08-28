/**
 * Util.java
 * cadi
 * VIRTUAL_MACHINE_MONO
 * vm.business
 */
package vm.business;

import java.util.BitSet;

/**
 * @author cadi
 *
 */
public class Util {

	
	/**
	 * Metodo pego da internet para converter um bit set para inteiro
	 * @param bs
	 * @return
	 */
	public static int bitSetToInt(BitSet bs) {
		int aux = 0;
		for (int i = 31 ; i >= 0;i--) {
			aux <<= 1;
			aux += bs.get(i)? 1:0;
		}
		return aux;
	}
	
	
	/**
	 * Metodo pego da internet que converte um numero inteiro para bitset
	 * @param nro
	 * @return
	 */
	public static BitSet intToBitSet(int nro) {
		BitSet bs = new BitSet();
		for (int i = 0 ; i < 32 ;i++) {
			if ((nro & 0x1) == 0x1) 
			{
				bs.set(i);
			}
			nro >>= 1;
		}
		return bs;
	}
	
	
}
