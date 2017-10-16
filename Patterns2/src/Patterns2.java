import javafx.util.Pair;

public class Patterns2 {
    public static void main(String args[]) {
        
        
        new HeaderArray<Integer>(new SizeMentionArray<>(new DelimiterArray<>(1,2,3,4), true), "Header").print(" _ ", System.out);
        new EnclosureArray<Integer>(new DelimiterArray<>(1,2,3,4), "sn ").print("_+_", System.out);
        new EnclosureArray<Integer>(new HeaderArray<>(new DelimiterArray<>(1,2,3,4), "Elements: "), "[ ]")
                .print(", ", System.out);
        new HeaderArray<Integer>(new HeaderArray<>(new DelimiterArray<>(1,2,3,4), "Elements: "), "[ ]")
                .print(", ", System.out);
        new HeaderArray<Integer>(new EnclosureArray<>(new DelimiterArray<>(1,2,3,4), "{ }"), "[Elements]: ")
                .print(", ", System.out);
        
        
        
    }
    
}
