import java.io.PrintStream;

public class SizeMentionArray<E> extends DelimiterArray<E>{
    private Sequence<E> seq;
    private Boolean sizeMention;
    
    public SizeMentionArray(Sequence<E> seq, Boolean sizeMention){
        this.seq = seq;
        this.sizeMention = sizeMention;
    }

    public void print(String delimiter, PrintStream ps) {
        try{
            seq.print(delimiter, ps);
            if(sizeMention){
                ps.print(" for a total of " + size() + " elements");
            }
            ps.println();
        }catch (NullPointerException e){
            System.out.println("bad args");
        }
    }
}
