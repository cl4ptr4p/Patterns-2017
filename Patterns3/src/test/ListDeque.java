package test;

import java.util.Iterator;

public class ListDeque<E> implements Deque<E> {
    private static class Node<E>{
        E data;
        Node<E> next;
    }
    
    
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;
    
    public int size(){
        return this.size;
    }
    
    private void checkIndex(int i){
        if(i >= size || i < 0){
            throw new IndexOutOfBoundsException("There's no element with index " + i);
        }
    }
    
    @Override
    public E first() {
        checkIndex(0);
        return head.data;
    }
    
    @Override
    public E last() {
        checkIndex(size - 1);
        return tail.data;
    }
    
    @Override
    public void addFirst(E elem) {
        Node<E>node = new Node<>();
        node.data = elem;
        node.next = null;
        if(head != null){
            head.next = node;
        }
        head = node;
        if(size == 0){
            tail = node;
        }
        size++;
    }
    
    @Override
    public void addLast(E elem) {
        Node<E> node = new Node<>();
        node.next = tail;
        node.data = elem;
        tail = node;
        if(size == 0){
            head = node;
        }
        size++;
    }
    
    @Override
    public E removeFirst() {
        checkIndex(0);
        E ans = head.data;
        if(size == 1){
            head = null;
            tail = null;
        }else {
            Node<E>prev = getNode(1);
            prev.next = null;
            head = prev;
        }
        size--;
        return ans;
    }
    
    @Override
    public E removeLast() {
        checkIndex(size - 1);
        E ans = tail.data;
        if(size == 1){
            head = null;
            tail = null;
        }else {
            Node<E>next = tail.next;
            tail.next = null;
            tail = next;
        }
        size--;
        return ans;
    }
    
    
    private Node<E> getNode(int i){
        checkIndex(i);
        Node<E>ans = tail;
        int cursor = size - 1;
        while (cursor > i){
            ans = ans.next;
            cursor--;
        }
        return ans;
    }
    
    public void getAll(){
        int cursor = 0;
        Node<E>node = tail;
        while(cursor < size){
            System.out.print(node.data.toString() + " ");
            node = node.next;
            cursor++;
        }
        System.out.println("\n- - - - - - - -");
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E>node = tail;
            int j = 0;
            @Override
            public boolean hasNext() {
                return j != size;
            }
    
            @Override
            public E next() {
                E ans = null;
                if(hasNext()){
                    ans = node.data;
                    node = node.next;
                }
                j++;
                return ans;
            }
        };
    }
}
