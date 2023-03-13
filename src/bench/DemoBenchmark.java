package bench;

import java.util.*;

public class DemoBenchmark implements IBenchmark {
    private int n, array[];

    // BubbleSort Algorithm
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Override
    public void initialize(Object... params) {
        Random random = new Random();
        this.n = (Integer) params[0];
        this.array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000);
        }

    }

    @Override
    public void run(Object... params) {
        initialize(array);
        bubbleSort(array);
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run() {

    }

}
