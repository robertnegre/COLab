package testbench;


import logging.*;
import timing.*;
import bench.*;

public class TestDemoBench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILog log = new ConsoleLogger();
        TimeUnit Milisecond = TimeUnit.Mili;
        TimeUnit Microsecond = TimeUnit.Micro;
        TimeUnit Second = TimeUnit.Sec;

        IBenchmark bench = new DemoBenchmark();
        bench.initialize(1000);
        timer.start();
        bench.run();
        long time = timer.stop();
        log.writeTime("Finished in", time, Microsecond);
        log.writeTime("Finished in", time, Milisecond);
        log.writeTime("Finished in", time, Second);
        log.close();
        bench.clean();

        final int workload = 1000;
        bench.initialize(workload);
        for (int i = 0; i < 12; ++i) {
            timer.resume();
            bench.run();
            long time1 = timer.pause();
            log.writeTime("Run " + i + " : ", time1, Microsecond);
        }
        log.write("Finished in : " + timer.stop());
    }
}