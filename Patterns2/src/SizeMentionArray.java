import java.io.PrintStream;

public class SizeMentionArray<E> implements Sequence<E>{
    private Sequence<E> seq;

    public SizeMentionArray(Sequence<E> seq){
        this.seq = seq;
    }

/*    public SizeMentionArray(E... args){
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

    public void print(String delimiter, Boolean sizeMention, PrintStream ps) {
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
