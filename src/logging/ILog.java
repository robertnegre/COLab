package logging;

public interface ILog {

    // will print the long parameter
    void write(long value);

    // will print the string parameter
    void write(String string);

    // will print all values separated by space
    void write(Object... values);

    void writeTime(String string, long value, TimeUnit unit);

    // used to close (if necessary) any open stream (connection) used for writing
    void close();
}
