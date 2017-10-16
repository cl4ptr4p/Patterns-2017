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

    public void print(String delimiter, String enclosure, PrintStream ps){
        try{
            ps.print(enclosure.substring(0, enclosure.indexOf(' ')));
            seq.print(delimiter, ps);
            ps.print(enclosure.substring(enclosure.indexOf(' ') + 1));
            ps.println();
        }catch (NullPointerException e){
            System.out.println("Bad arguments");
        }
    }
}
