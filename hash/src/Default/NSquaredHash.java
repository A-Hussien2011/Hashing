/**
 *
 */
package Default;

/**
 * @author a7med
 */
public class NSquaredHash implements IHash {

    private final int[] keys;
    //TODO: Change the type of the hashTable if preferred
    private int[] hashTable;
    private HashTableGenerator hash;

    public NSquaredHash(int[] keys) {
        this.keys = keys;
        hash = new HashTableGenerator(keys.length);
        hash.generateHashFn();
        this.hashTable = new int[keys.length * keys.length];
    }

    @Override
    public boolean search(int key) {
        return false;
    }
}
