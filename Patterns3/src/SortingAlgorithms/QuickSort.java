package SortingAlgorithms;

public class QuickSort {

    public static <E extends Comparable<E>> void sort(E[] array){
        quick(array, 0, array.length - 1);
    }
    
    private static <E extends Comparable<E>> void quick(E[] array, int left, int right){
        int l = left;
        int r = right;
        int pivot = (int)(Math.random() * (r - l) + l);
        if(r - l <= 0){
            return;
        }
        while(l < r){
            while(array[l].compareTo(array[pivot]) < 0 && l < pivot){
                l++;
            }
            while(array[r].compareTo(array[pivot]) >= 0 && r > pivot){
                r--;
            }
            if(r > l){
                E data = array[l];
                array[l] = array[r];
                array[r] = data;
            }
        }
        quick(array, 0, pivot - 1);
        quick(array, pivot + 1, right);
    }
}
