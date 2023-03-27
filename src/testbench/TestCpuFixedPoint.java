package testbench;

import bench.cpu.*;
import bench.*;
import logging.*;
import timing.*;

public class TestCpuFixedPoint {
    public static void main(String[] args)
    {
        int size = 1000000;
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Nanosecond = TimeUnit.Nano;
        TimeUnit Second = TimeUnit.Sec;
        IBenchmark bench = new CPUFixedPoint();
        bench.initialize();
        bench.warmUp();
        timer.start();
        bench.run(1, size);
        long time = timer.stop();
        log.writeTime("Finished in", time, Nanosecond);
        double timer2=time/1000000000.0;
        double MOPS = (9.0*size)/(timer2*1e6);
        log.write("MOPS value:", MOPS);
        log.close();
        bench.clean();
    }
}