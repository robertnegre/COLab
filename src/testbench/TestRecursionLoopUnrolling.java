package testbench;

import bench.cpu.*;
import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.TimeUnit;
import logging.ILog;
import timing.Timer;
import timing.ITimer;

public class TestRecursionLoopUnrolling {
    public static void main(String[] args)
    {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;
        long size = 10000000;
        IBenchmark bench = new CPURecursionLoopUnrolling();
        bench.initialize(1, (long)size);
        timer.start();
        bench.run(false);
        long time = timer.stop();
        log.writeTime("Finished in: ", time, Milisecond);
        bench.initialize(1, (long)size);
        int unrollLevel=5;
        timer.start();
        bench.run(true,unrollLevel);
        long time1 = timer.stop();
        log.writeTime("Finished in: ", time1, Milisecond);
        long score=bench.score(time1,unrollLevel);
        log.write("Score: " + score);
        log.close();
        bench.clean();
    }
}

//score = calls/time