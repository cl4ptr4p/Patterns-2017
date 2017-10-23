package SortingAlgorithms;

public class InsertionSort {
    public static <E extends Comparable<E>> void sort(E[] array){
        for(int i = 0; i < array.length; i++){
            int min = i;
            for(int j = i; j < array.length; j++){
                if(array[j].compareTo(array[min]) < 0){
                    min = j;
                }
            }
            E data = array[min];
            array[min] = array[i];
            array[i] = data;
        }
        
    }
    
}
