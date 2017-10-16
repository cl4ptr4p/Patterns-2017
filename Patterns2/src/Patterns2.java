import javafx.util.Pair;

public class Patterns2 {
    public static void main(String args[]) {
        
        new SizeMentionArray<>(new DelimiterArray<>(1, 2, 3, 4)).print("_-_", false, System.out);
        new HeaderArray<>(new DelimiterArray<>(1, 2, 3, 4)).print("_-_", "true", System.out);
        new EnclosureArray<>(new DelimiterArray<>(1.2, 2.2, 0.4)).print("_-_", "true true", System.out);
        new SizeMentionArray<>(new DelimiterArray<>('1', '2', '3', '4')).print("_-_", false, System.out);
        
        new CombinedArray<>(new HeaderArray<>(new DelimiterArray<>(1, 2, 3, 4)))
                .print(" ._. ", "Wazzzup ", "{\\[]/}", true, System.out);
    
        new CombinedArray<>(new SizeMentionArray<>(new DelimiterArray<>(new Pair(1,2), new Pair(3,4))))
                .print(" ._. ", "Wazzzup ", "{\\[ ]/}", true, System.out);
        
    }
    
}
