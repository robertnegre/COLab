package bench;

public interface IBenchmark {

    // the method which will contain the core of the code used to actually benchmark
    // a hardware component
    void run();

    void run(Object... params);

    // here we place all code needed to prepare the data for the run method to execute
    void initialize(Object... params);

    // here we might need to clean up after the run method
    void clean();

    // useful mainly when exposing a UI (user interface) to a client,
    // so that we can cancel the execution at any time
    void cancel();

/**
 * Called right before running the algorithm itself to "warm-up" the task at
 * hand. <br>
 * The warm up should do the exact task as the run method, however it should not
 * be timed. <br>
 * The amount of warm-up data/time should be between 10-100% of the total time.
 * <br>
 * This call should not be benchmarked.
 */

    public void warmUp();

}
