package Default;

public class Testing {

	public static void main(String[] args) {
		/*int[] key = {1,8,9,15,15};


		QuadraticHash q = new QuadraticHash(key);
		System.out.println(q.search(14));*/

		LinearHash linearHash = new LinearHash(FileReader.getKeysFromFile("hash\\src\\keys10000001000000.txt"));
		System.out.println(linearHash.search(-1));
		System.out.println(linearHash.search(8));
		System.out.println(linearHash.search(-2));
		System.out.println(linearHash.search(3));
		System.out.println(linearHash.search(9));
		System.out.println(linearHash.search(15));

	}

	public static void printarr2d(int [][] matrix){
		for (int i=0; i<matrix.length; i++) {
		    for (int j=0; j<matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
	public static void printarr(QuadraticNode[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i].getValue());
		}
	}

}
