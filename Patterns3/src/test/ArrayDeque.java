package test;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.lang.Class;

public class ArrayDeque<E> implements Deque<E> {
    private E[] array;
    private int head;
    private int tail;


    public ArrayDeque(Class<E> c, int size){
        final E[] array = (E[])Array.newInstance(c, size);
        this.array = array;
        for(int i = 0; i < size; i++){
            this.array[i] = null;
        }
        head = size / 2;
        tail = size / 2;
        
    }
    
    private void checkSize(){
        int ans = tail - head;
        if(ans < 0){
            ans = array.length - ans;
        }
        if(ans == 0 && array[head] != null){
            ans = 1;
        }
        if(ans == 0){
            throw new NullPointerException();
        }
    }
    
    @Override
    public E first() {
        checkSize();
        return array[head];
    }
    
    @Override
    public E last() {
        checkSize();
        return array[tail];
    }
    
    private void resize(){
        E[]secondArray = (E[])Array.newInstance(array.getClass().getComponentType(), array.length * 2);
        Iterator<E>iterator = iterator();
        int k = array.length / 2;
        while(iterator.hasNext()){
            secondArray[k] = iterator.next();
            k++;
        }
        head = array.length / 2;
        tail = k - 1;
        array = secondArray;
    }
    
    @Override
    public void addFirst(E elem) {
        if(tail - head == 0 && array[head] == null){
            array[head] = elem;
            return;
        }
        int destination = head;
        if(destination == 0){
            destination = array.length;
        }
        destination--;
        
        if(array[destination] != null){
            resize();
        }else {
            array[destination] = elem;
            head = destination;
        }
    }
    
    
    @Override
    public void addLast(E elem) {
        if(tail - head == 0 && array[head] == null){
            array[tail] = elem;
            return;
        }
        int destination = tail;
        if(destination == array.length - 1){
            destination = -1;
        }
        destination++;
    
        if(array[destination] != null){
            resize();
        }else {
            array[destination] = elem;
            tail = destination;
        }
        
    }
    
    @Override
    public E removeFirst() {
        checkSize();
        E ans = array[head];
        array[head] = null;
        if(head == tail){
            return ans;
        }
        head++;
        if(head == array.length){
            head = 0;
        }
        return ans;
    }
    
    @Override
    public E removeLast() {
        checkSize();
        E ans = array[tail];
        array[tail] = null;
        if(head == tail){
            return ans;
        }
        tail--;
        if(tail == -1){
            tail = array.length - 1;
        }
        return ans;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = head;
            boolean flag = true;
            @Override
            public boolean hasNext() {
                return flag;
            }
            @Override
            public E next() {
                E data = array[cursor];
                if(cursor == tail){
                    flag = false;
                }
                cursor++;
                if(cursor == array.length){
                    cursor = 0;
                }
                return data;
            }
        };
    }
    
    public void getAll(){
        Iterator<E>iterator = this.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + " ");
        }
        System.out.println();
    }
}
