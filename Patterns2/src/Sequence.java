import java.io.PrintStream;




public interface Sequence<E> {
    void print(String delimiter, PrintStream ps);
//    void print(String delimiter, String header, String enclosure, Boolean size, PrintStream ps);
//    void print();
    int size();
}
