import java.io.PrintStream;

public class DelimiterArray<E> implements Sequence<E> {
    
    private E[] array;

    public DelimiterArray(E... args){
        array = args;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        try {
            for (int i = 0; i < array.length; ) {
                ps.print(array[i].toString());
                i++;
                if (i < array.length && delimiter != null) {
                    ps.print(delimiter);
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Bad arguments");
        }

    }


}
