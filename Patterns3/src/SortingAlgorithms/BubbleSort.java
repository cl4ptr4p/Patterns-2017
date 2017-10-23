package SortingAlgorithms;

public class BubbleSort{
    public static <E extends Comparable<E>> void sort(E[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if(array[i].compareTo(array[j]) > 0){
                    E data = array[i];
                    array[i] = array[j];
                    array[j] = data;
                }
            }
        }
        
    }
}
