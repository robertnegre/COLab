package timing;

import timing.TimerState;

public class Timer implements ITimer {

    private long start, end, totalTime;
    private TimerState state;

    public Timer() {

        state = TimerState.Stopped;
    }

    @Override
    public void start() {

        totalTime = 0;
        state = TimerState.Running;
        start = System.nanoTime();
    }

    @Override
    public long stop() {

        if (state.equals(TimerState.Running)) {
            end = System.nanoTime();
            state = TimerState.Stopped;
            totalTime = totalTime + end - start;
            return totalTime;
        } else {
            return totalTime;
        }
    }

    @Override
    public void resume() {
        state = TimerState.Running;
        start = System.nanoTime();
    }

    @Override
    public long pause() {
        end = System.nanoTime();
        totalTime = totalTime + end - start;
        state = TimerState.Stopped;
        return end - start;
    }
}
