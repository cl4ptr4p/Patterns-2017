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

    //note that if  "enclosure" doesn't have space in it, the answer will be enclosed in the whole string
    //for example print("", "- -",ps) -> -1234-   while print ("", "--", ps) -> --1234--

    public void print(String delimiter, String header, String enclosure, Boolean sizeMention, PrintStream ps){
        try{
            ps.print(header);
            int i = enclosure.indexOf(' ');
            ps.print(i >= 0? enclosure.substring(0, i): enclosure);
            seq.print(delimiter, ps);
            ps.print(i >= 0? enclosure.substring(i + 1): enclosure);
            if(sizeMention){
                ps.print(" for a total of " + size() + " elements");
            }
            ps.println();
        }catch (NullPointerException e){
            System.out.println("Bad arguments");
        }
    }
}
