package Default;

public class LinearHash implements IHash {

    private final int[] keys;
    private int HASH_TABLE_COLLISIONS_THRESHOLD;
    private HashTableNode[] hashTable;
    private HashTableGenerator hash;

    public LinearHash(int[] keys) {
        this.keys = keys;
        this.HASH_TABLE_COLLISIONS_THRESHOLD = 4 * keys.length;
        initTable();
        insertKeys();
    }

    private void initTable() {
        this.hash = new HashTableGenerator(keys.length);
        this.hash.generateHashFn();
        this.hashTable = new HashTableNode[keys.length];
    }

    private void insertKeys() {
        for (int key : keys) {
            hashTable[hash.getIndex(key)].insertKey(key);
        }

        for (HashTableNode hashTableNode : hashTable) {
            hashTableNode.setAllElementsInserted();
        }

        int collisions = 0;
        for (HashTableNode node : hashTable) {
            collisions += node.hasCollision() ? node.getNumberOfElements() : 0;
        }

        if (collisions > HASH_TABLE_COLLISIONS_THRESHOLD) {
            reconstructTable();
        }
    }

    private void reconstructTable() {
        initTable();
        insertKeys();
    }

    @Override
    public boolean search(int key) {
        return hashTable[hash.getIndex(key)].hasKey(key);
    }
}
