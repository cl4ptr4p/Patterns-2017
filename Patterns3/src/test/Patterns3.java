package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Patterns3 {
    
    public static void foo(Deque a) {
        System.out.println("head " + a.first());
        System.out.println("tail " + a.last());
        System.out.println("_______");
    }
    
    public static void main(String[] args) {
        
        String name = args[0];
        int size = 0;
        if (name.equals("ArrayDeque")) {
            size = Integer.parseInt(args[1]);
            if (size < 0) {
                throw new NegativeArraySizeException("bad size");
            }
        }
        test.Deque<Integer> deque = null;
        try {
            Class<?> integerClass = Class.forName("test." + name);
            Constructor construct = integerClass.getConstructors()[0];
            if (size != 0) {
                deque = (Deque<Integer>) integerClass.getConstructor(Class.class, int.class).newInstance(Integer.class, size);
//                deque = (Deque<Integer>) construct.newInstance(Integer.class, size);
            } else {
                deque = (Deque<Integer>) integerClass.newInstance();
//                deque = (Deque<Integer>) construct.newInstance(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < ((int) (Math.random() * 10 + 1)); i++) {
            deque.addFirst((int) (Math.random() * 10 + 1));
        }
        
        int sum = 0;
        Iterator<Integer> integerIterator = deque.iterator();
        while (integerIterator.hasNext()) {
            sum += integerIterator.next();
        }
        
        System.out.println(sum);
        
        String ans = "There's no method \"size\"";
        try {
            Method sizeMethod = deque.getClass().getMethod("size", null);
            ans = sizeMethod.invoke(deque, null).toString();
            ans = "Deque has " + ans + " elements";
        } catch (Exception e) {
 //           e.printStackTrace();
        }
        
        System.out.println(ans);
        
        
    }
    
}
