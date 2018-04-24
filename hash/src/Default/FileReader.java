package Default;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public class FileReader {
    private FileReader() {

    }

    public static int[] getKeysFromFile(String fileName) {
        String keys;
        String[] keysStringArray = new String[1];
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName));

            while ((keys = bufferedReader.readLine()) != null) {
                keysStringArray = keys.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getUniqueKeys(keysStringArray);
    }

    private static int[] getUniqueKeys(String[] keysStringArray) {

        HashSet<Integer> keysSet = new HashSet<>(keysStringArray.length);

        for (String key : keysStringArray) {
            keysSet.add(Integer.parseInt(key));
        }

        int[] keysArray = new int[keysSet.size()];
        int counter = 0;
        for (Integer key : keysSet) {
            keysArray[counter++] = key;
        }

        return keysArray;
    }
}
