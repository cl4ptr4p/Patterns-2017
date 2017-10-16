import java.io.PrintStream;

public class HeaderArray<E> implements Sequence<E>{
    public Sequence<E> seq;

    public HeaderArray (Sequence<E> seq){
        this.seq = seq;
    }

  /*  public HeaderArray (E... args){
        seq = new DelimiterArray(args);
    }
*/
    @Override
    public void print(String delimiter, PrintStream ps) {
        seq.print(delimiter, ps);
    }

    @Override
    public int size() {
        return seq.size();
    }

    public void print(String delimiter, String header, PrintStream ps){
        try{
            ps.print(header + " ");
            seq.print(delimiter, ps);
            ps.println();
        }catch (NullPointerException e){
            System.out.println("bad args");
        }
    }
}
