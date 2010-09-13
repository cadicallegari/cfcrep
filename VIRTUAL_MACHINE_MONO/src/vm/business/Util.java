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


	/**
	 * @param regDst
	 * @return
	 */
	public static String booleanToString(boolean b) {
		
		String str = null;
		
		if (b) {
			str = "1";
		} else {
			str = "0";
		}
		
		return str;
	}


	/**
	 * @param i
	 * @return
	 */
	public static Object intToBinary(int i) {
		return convertToBin(i);
	}
	
	
	private static String convertToBin(int x) {
		String bin="";  
	    
		if (x > 0) {
			if(x % 2 == 0) {
				bin = (convertToBin(x / 2)+ "0");  
			}
			else {
				bin = (convertToBin(x / 2) + "1");  
			}
	        
		}  
		return bin;  
	} 
	
}
