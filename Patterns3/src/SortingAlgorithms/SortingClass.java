package SortingAlgorithms;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class SortingClass {
    public static void main(String[] args){
        int size = 10;
        Integer[] a = (Integer[]) Array.newInstance(Integer.class, size);
        for(int j = 0; j < size; j++){
            a[j] = (int)(Math.random() * 20 + 1);
        }
        for(int i = 0; i < size; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("\n Sorted:");
    
        try {
            Class<?>c = Class.forName("SortingAlgorithms." + args[0]);
            Method method = c.getMethod("sort", Comparable[].class);
            method.invoke(null, (Object)a);
        }catch (Exception e){
            e.printStackTrace();
        }
        for(int i = 0; i < size; i++){
            System.out.print(a[i] + " ");
        }
    
    }
}
