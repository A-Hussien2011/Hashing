package Default;

public class Testing {

	public static void main(String[] args) {
		HashTableGenerator hash = new HashTableGenerator(2);
		hash.generateHashFn();
		printarr2d(hash.hashFn);
		//printarr(hash.generateBinaryKey(15));
		printarr(hash.generateKey(15));
		
	}
	
	public static void printarr2d(int [][] matrix){
		for (int i=0; i<matrix.length; i++) {
		    for (int j=0; j<matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
	public static void printarr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

}
