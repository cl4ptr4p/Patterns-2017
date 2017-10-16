import com.sun.org.glassfish.gmbal.ParameterNames;

import java.io.PrintStream;

public class EnclosureArray<E> implements Sequence<E> {
    private Sequence<E> seq;

    public EnclosureArray(Sequence<E> seq){
        this.seq = seq;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        seq.print(delimiter, ps);
    }

    @Override
    public int size() {
        return seq.size();
    }

    //note that if "enclosure" doesn't have space in it, the answer will be enclosed in the whole string
    //for example print("", "- -",ps) -> -1234-   while print ("", "--", ps) -> --1234--
    public void print(String delimiter, String enclosure, PrintStream ps){
        try{
            int i = enclosure.indexOf(' ');
            ps.print(i >= 0? enclosure.substring(0, i): enclosure);
            seq.print(delimiter, ps);
            ps.print(i >= 0? enclosure.substring(i + 1): enclosure);
            ps.println();
        }catch (NullPointerException e){
            System.out.println("Bad arguments");
        }
    }
}
