package SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertSort extends SortAlgorithm {

    public InsertSort(int nbElem) {
        super(nbElem);
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
                sleepAndSetIndex(j);
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
            sleepAndSetIndex(i);
        }
    }


}
