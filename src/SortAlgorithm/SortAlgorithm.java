package SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class SortAlgorithm implements Runnable {

    protected int[] array;
    protected List<Integer> indexes = new ArrayList<>();

    private Thread t;

    public SortAlgorithm(int nbElem) {
        array = new int[nbElem];
        random(array, nbElem);
        t = new Thread(this);
    }

    public void start() {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }

    private void random(int[] array, int nbElem) {
        Random r = new Random();
        int value;
        for (int i = 0; i < nbElem; i++) {
            value = r.nextInt(100);
            array[i] = value;
        }
    }

    public int getNumberElements() {
        return array.length;
    }

    public List<Integer> getCurrentIndex() { return indexes; };

    public int[] getList() {
        return array;
    }

    public abstract void run();

    protected void sleepAndSetIndex(Integer ... index) {
        getCurrentIndex().clear();
        getCurrentIndex().addAll(Arrays.asList(index));
        try {
            Thread.sleep(0, 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
