package timing;

public interface ITimer {

    // saves the current elapsed time in a long variable, and resets any
    // previously stored total time
    void start();

    // returns the elapsed time since the start of the timer
    long stop();

    // saves the current elapsed time in a variable, without resetting any
    // previous saved times
    void resume();

    // returns the elapsed time (difference) since the last start or resume of the timer
    long pause();
}
