import java.io.PrintStream;

public class HeaderArray<E> extends DelimiterArray<E>{
    private Sequence<E> seq;
    private String header;

    public HeaderArray (Sequence<E> seq, String header){
        this.seq = seq;
        this.header = header;
    }
    
    public void print(String delimiter, PrintStream ps){
        try{
            ps.print(header + " ");
            seq.print(delimiter, ps);
            ps.println();
        }catch (NullPointerException e){
            System.out.println("bad args");
        }
    }
}
