/**
 *
 */
package Default;

/**
 * @author a7med
 */
public class QuadraticHash implements IHash {

    private final int[] keys;
    private QuadraticNode[] hashTable;
    private HashTableGenerator hash;
    public QuadraticNode[] getHashTable() {
		return hashTable;
	}



	public void setHashTable(QuadraticNode[] hashTable) {
		this.hashTable = hashTable;
	}

	

    public QuadraticHash(int[] keys) {
        this.keys = keys;
        hash = new HashTableGenerator(keys.length);
        hash.generateHashFn();
        this.hashTable = new QuadraticNode[keys.length * keys.length];
        this.buildHashTable(keys);
    }


	private void buildHashTable(int[] keys) {
    	boolean noCollision = insertKeys(keys);
    	while(!noCollision){
    		hash.generateHashFn();
            this.hashTable = new QuadraticNode[keys.length * keys.length];
            noCollision = insertKeys(keys);
    	}
	}
    
	private boolean insertKeys(int[] keys) {
		for(int i = 0; i < hashTable.length; i++){
			hashTable[i] = new QuadraticNode();
		}
		for(int key: keys){
			int index = hash.getIndex(key);
			if(hashTable[index].isVisited()){
				return false;
			} else{
				hashTable[index] = new QuadraticNode();
				hashTable[index].setValue(key);
				hashTable[index].setVisited(true);
			}
		}
		return true;
	}

	@Override
    public boolean search(int key) {
		int index = hash.getIndex(key);
        return hashTable[index].getValue() == key;
    }
}
