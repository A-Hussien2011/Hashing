/**
 * 
 */
package Default;

/**
 * @author a7med
 *
 */
public class NSquaredHash implements IHash {
	HashTableGenerator hash;
	public NSquaredHash(int n){
		hash = new HashTableGenerator(n);
		hash.generateHashFn();
	}
	@Override
	public boolean search(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean insert(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(int value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
