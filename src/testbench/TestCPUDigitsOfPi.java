package testbench;

import bench.*;
import benchmark.cpu.*;
import logging.*;
import timing.*;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        IBenchmark bench = new CPUDigitsOfPi();
        bench.initialize();
        timer.start();
        bench.run(1);
        long time = timer.stop();
        log.writeTime("Finished in", time, Milisecond);
        log.close();
        bench.clean();
    }
}
