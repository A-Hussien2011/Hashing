package Default;

public class LinearHash implements IHash {

    private int[] keys;
    private int HASH_TABLE_COLLISIONS_THRESHOLD;
    private HashTableNode[] hashTable;
    private HashTableGenerator hash;

    public LinearHash(int[] keys) {
        this.keys = keys;
        this.HASH_TABLE_COLLISIONS_THRESHOLD = 4 * keys.length;
        initTable();
        insertKeys();
        this.keys = null;
    }

    private void initTable() {
        this.hash = new HashTableGenerator((int) Math.sqrt(keys.length));
        this.hash.generateHashFn();
        this.hashTable = new HashTableNode[keys.length];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new HashTableNode();
        }
    }

    private void insertKeys() {
        for (int key : keys) {
            int index = hash.getIndex(key);
            hashTable[index].insertKey(key);
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
