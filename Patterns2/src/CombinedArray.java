import java.io.PrintStream;

public class CombinedArray<E> implements Sequence<E> {
    private Sequence<E> seq;

    public CombinedArray(Sequence<E> seq){
        this.seq = seq;
    }

    @Override
    public int size() {
        return seq.size();
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        seq.print(delimiter, ps);
    }

    public void print(String delimiter, String header, String enclosure, Boolean sizeMention, PrintStream ps){
        try{
            ps.print(header);
            ps.print(enclosure.substring(0, enclosure.indexOf(' ')));
            seq.print(delimiter, ps);
            ps.print(enclosure.substring(enclosure.indexOf(' ') + 1));
            if(sizeMention){
                ps.print(" for a total of " + size() + " elements");
            }
            ps.println();
        }catch (NullPointerException e){
            System.out.println("Bad arguments");
        }
    }
}
