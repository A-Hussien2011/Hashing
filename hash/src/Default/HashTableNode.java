package Default;

import java.util.ArrayList;

//For the LinearHash
public class HashTableNode {
    private int numberOfElements;
    private boolean hasCollision;
    private NSquaredHash collisionHashTable;
    private ArrayList<Integer> tempContainer;
    private boolean isStable;
    private int singleKey;

    public HashTableNode() {
        this.numberOfElements = 0;
        this.hasCollision = false;
        tempContainer = new ArrayList<>();
    }

    public void insertKey(int key) {
        if (getNumberOfElements() > 0) {
            setHasCollision(true);
        }
        tempContainer.add(key);
    }

    public boolean hasKey(int key) {
        if (isStable) {
            if (numberOfElements > 1) {
                return collisionHashTable.search(key);
            } else {
                return key == singleKey;
            }
        }
        return false;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public boolean hasCollision() {
        return hasCollision;
    }

    private void setHasCollision(boolean hasCollision) {
        this.hasCollision = hasCollision;
    }

    public void setAllElementsInserted() {
        this.isStable = true;
        this.numberOfElements = tempContainer.size();

        if (numberOfElements > 1) {
            int[] keys = new int[numberOfElements];

            for (int i = 0; i < keys.length; i++) {
                keys[i] = tempContainer.get(i);
            }

            this.collisionHashTable = new NSquaredHash(keys);
        } else if (numberOfElements == 1) {
            singleKey = tempContainer.get(0);
        }

        this.tempContainer = null;
    }
}
