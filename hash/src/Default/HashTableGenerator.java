/**
 * 
 */
package Default;

/**
 * @author a7med
 *
 */
public class HashTableGenerator {
	public int[][] hashFn;
	
	public HashTableGenerator(int n){
		hashFn = new int[n][5];
	}
	
	public void generateHashFn(){
		for (int i=0; i<hashFn.length; i++) {
		    for (int j=0; j<hashFn[i].length; j++) {
		        hashFn[i][j] = (int) (Math.random()*2);
		    }           
		}
	}
	
	public int[] generateKey(int number){
		int[] binkey = generateBinaryKey(number);
		int[] key = new int[hashFn.length];
		for(int i = 0; i < hashFn.length; i++){
			for(int j = 0; j < hashFn[0].length; j++){
				key[i] ^= hashFn[i][j] & binkey[j];
			}
		}
		return key;
	}
	
	public int[] generateBinaryKey(int number){
		String binaryString = Integer.toBinaryString(number);
		int[] key = new int[5];
		int count = 0;
		for (int i = binaryString.length() - 1 ; i >= 0; i--) {
	        if(binaryString.charAt(i) == '1'){
	        	key[count] = 1;
	        } else{
	        	key[count] = 0;
	        }
	        count ++;
	    }
		return key;
	}
}
