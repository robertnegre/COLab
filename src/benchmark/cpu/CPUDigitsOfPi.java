package benchmark.cpu;

import bench.*;

public class CPUDigitsOfPi implements IBenchmark {

    private int size;

    @Override
    public void initialize(Object... params) {
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.size; i++) {
            piDigit(i);
            //System.out.print(piDigit(i));
        }
    }

    private int piDigit(int n) {
        if (n < 0)
            return -1;

        n -= 1;
        double x = 4 * piTerm(1, n) - 2 * piTerm(4, n) - piTerm(5, n)
                - piTerm(6, n);
        x = x - Math.floor(x);

        return (int) (x * 16);
    }

    private double piTerm(int j, int n) {
        double s = 0;
        for (int k = 0; k <= n; ++k) {
            int r = 8 * k + j;
            s += powerMod(16, n - k, r) / (double) r;
            s = s - Math.floor(s);
        }
        double t = 0;
        int k = n + 1;
        while (true) {
            int r = 8 * k + j;
            double newt = t + Math.pow(16, n - k) / r;
            if (t == newt) {
                break;
            } else {
                t = newt;
            }
            ++k;
        }
        return s + t;
    }

    private long powerMod(long a, long b, long m) {
        long tempo;
        if (b == 0) {
            tempo = 1;
        } else if (b == 1)
            tempo = a;
        else {
            long temp = powerMod(a, b / 2, m);
            if (b % 2 == 0)
                tempo = (temp * temp) % m;
            else
                tempo = ((temp * temp) % m) * a % m;
        }
        return tempo;
    }

    @Override
    public void run(Object... params) {

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
}
