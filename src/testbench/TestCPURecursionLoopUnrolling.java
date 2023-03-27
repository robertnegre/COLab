package testbench;

import bench.*;
import bench.cpu.*;

public class TestCPURecursionLoopUnrolling {

    public static void main(String[] args) {
        IBenchmark benchmark = new CPURecursionLoopUnrolling();

        benchmark.initialize(2000000L);

        benchmark.run(false);
        // output: Reached nr 47352/2000000 after 4883 calls. Finished in 21.8513 Milli

        benchmark.run(true, 1);
        // output: Reached nr 43854/2000000 at 1 levels after 456
    }

}
