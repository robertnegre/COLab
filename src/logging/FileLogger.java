package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class FileLogger implements ILog {

    private PrintWriter file;

    public FileLogger( String filepath) {
        try {
            BufferedWriter LogFile = new BufferedWriter(new FileWriter(filepath, false));
            file = new PrintWriter(LogFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(long value) {
        file.println(value);
    }

    @Override
    public void write(String string) {
        file.println(string);
    }

    @Override
    public void write(Object... values) {
        String s="";
        for (Object value : values) {
            s += value.toString() + " ";
        }
        file.println(s);
    }

    @Override
    public void writeTime(String string, long value, TimeUnit unit) {

    }

    @Override
    public void close() {
        if(file != null)
            file.close();
    }
}