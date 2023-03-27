package bench.cpu;

import bench.IBenchmark;

public class CPURecursionLoopUnrolling implements IBenchmark {

    private long size;
    private boolean useUnrolling;
    private int unrollLevel;

    @Override
    public void run() {
        run(new Object[0]);
    }

    @Override
    public void run(Object... params) {
        if (params.length < 1) {
            throw new IllegalArgumentException("Missing parameter: useUnrolling");
        }
        useUnrolling = (boolean) params[0];
        if (useUnrolling) {
            if (params.length < 2) {
                throw new IllegalArgumentException("Missing parameter: unrollLevel");
            }
            unrollLevel = (int) params[1];
            recursiveUnrolled(1, unrollLevel, (int) size, 0);
        } else {
            recursive(1, size, 0);
        }
    }

    @Override
    public void initialize(Object... params) {
        if (params.length < 1) {
            throw new IllegalArgumentException("Missing parameter: size");
        }
        size = (long) params[0];
    }

    @Override
    public void clean() {
        // no cleanup needed
    }

    @Override
    public void cancel() {
        // no cancellation logic needed
    }

    @Override
    public void warmUp() {
        // no warm up needed
    }

    private long recursive(long start, long size, int counter) {
        if (start > size) {
            return 0;
        }
        if (isPrime(start)) {
            counter++;
        }
        try {
            return recursive(start + 1, size, counter);
        } catch (StackOverflowError e) {
            System.out.println("Reached nr " + start + "/" + size + " after " + counter + " calls.");
            return 0;
        }
    }

    private long recursiveUnrolled(long start, int unrollLevel, int size, int counter) {
        if (start > size) {
            return 0;
        }
        int numPrimes = 0;
        for (int i = 0; i < unrollLevel; i++) {
            if (isPrime(start + i)) {
                numPrimes++;
            }
            if (start + i >= size) {
                break;
            }
        }
        counter++;
        try {
            return numPrimes + recursiveUnrolled(start + unrollLevel, unrollLevel, size, counter);
        } catch (StackOverflowError e) {
            System.out.println("Reached nr " + (start + unrollLevel - 1) + "/" + size + " at " + unrollLevel +
                    " levels after " + counter + " calls.");
            return numPrimes;
        }
    }

    private boolean isPrime(long x) {
        if (x <= 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}


