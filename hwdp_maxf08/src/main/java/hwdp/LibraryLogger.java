package hwdp;
import java.util.ArrayList;

public class LibraryLogger {
    private static LibraryLogger instance = null;
    private ArrayList<String> writtenLines;

    private LibraryLogger() {
        writtenLines = new ArrayList<String>();
        ExpensiveComputeToy.performExpensiveLogSetup();
    }

    public void writeLine(String line) {
        writtenLines.add(line);
        System.out.println("LibraryLogger: " + line);
    }

    public String[] getWrittenLines() {
        String[] arr = new String[writtenLines.size()];
        writtenLines.toArray(arr);
        return arr;
    }

    public void clearWriteLog() {
        writtenLines.clear();
    }
    
    public static LibraryLogger getInstance() {
        if (instance == null) {
            instance = new LibraryLogger();
        }
        return instance;
    }
}
