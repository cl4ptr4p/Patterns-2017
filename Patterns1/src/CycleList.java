import java.util.Iterator;
import java.util.NoSuchElementException;

public class CycleList<E extends Comparable<E>> implements CycList {

    static class Node<E>{
        E data;
        Node<E> next;
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void shift(int delta){
        if(size > 0){
            delta = delta % size;
            int i = 0;
            while(i != delta){
                head = head.next;
                tail = tail.next;
                i++;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<E>{
        int i = 0;
        Node<E>node = head;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            E ans = node.data;
            node = node.next;
            i++;
            return ans;
        }
    }

    private void checkIndex(int i){
        if(i >= size || i < 0){
            throw new IndexOutOfBoundsException("This element doesn't exist (" + i + ")");
        }
    }

    public void addInto(E data, int pos){

        checkIndex(pos);
        Node<E>node = new Node<E>();
        node.data = data;
        node.next = head;

        Node<E>prev = getNode(pos);
        node.next = prev.next;
        prev.next = node;
        if(pos == size - 1){
            tail = node;
        }


    }

    public void add (E newdata){
        Node<E>node = new Node<E>();
        node.data = newdata;
        node.next = head;
        if(tail != null){
            tail.next = node;
        }
        tail = node;
        if(size == 0){
            head = node;
        }
        if(size == 1){
            head.next = node;
        }
        size++;
    }

    private Node<E> getNode (int i){
        checkIndex(i);
        int j = 0;
        Node<E> node = head;
        while (j < i){
            node = node.next;
            j++;
        }
        return node;
    }

    public E get (int i){
        Node<E> node = getNode(i);
        return node.data;
    }

    public String getAll(){
        int i = 0;
        Node<E> node = head;
        StringBuffer str = new StringBuffer( "_");
        while(i != size){
            str.append(node.data.toString());
            str.append( " ");
            node = node.next;
            i++;
        }
        return str.toString();
    }

    public void remove(int i){
        checkIndex(i);
        Node<E> prev;
        if(i >= 1){
            prev = getNode(i - 1);
        }else {
            prev = tail;
        }
        Node<E> node = getNode(i);
        if(node == head){
            head = node.next;
            if(size == 1){
                tail = null;
            }else {
                prev.next = head;
            }
        }
        if(node == tail){
            if(size == 1){
                head = null;
                tail = null;
            }else {
                prev.next = head;
                tail = prev;
            }
        }
        prev.next = node.next;
        size--;
    }


    public E head(){
        checkIndex(0);
        return head.data;
    }

    public E tail(){
        checkIndex(size - 1);
        return tail.data;
    }

    public int getSize(){
        return this.size;
    }


    public void swap (int i, int j){
        checkIndex(i);
        checkIndex(j);
        if(i == j){
            return;
        }
        if(j < i){
            i = i + j;
            j = i - j;
            i = i - j;
        }
        Node<E> a = getNode(i);
        Node<E> b = getNode(j);
        Node<E> _a = null;
        Node<E> _b = getNode(j - 1);
        Node<E> node = a.next;


        if(i >= 1){
            _a = getNode(i - 1);
            _a.next = b;
        }else {
            head = b;
        }

        a.next = b.next;
        if(j - i > 1){
            _b.next = a;
            b.next = node;
        }else {
            b.next = a;
        }

        if(j == size - 1){
            tail = a;
        }
    }

    private Integer getMinIndex(int first){
        int i = 0;
        Node<E>node = head;
        while (i < first){
            node = node.next;
            i++;
        }
        E min = node.data;
        int ans = i;
        node = node.next;
        i++;
        while(node != null){
            if(node.data.compareTo(min) < 0){
                ans = i;
                min = node.data;

            }
            node = node.next;
            i++;
        }
        return ans;
    }

    public void sort(){
        for(int i = 0; i < size; i++){
            swap(i, getMinIndex(i));
//            System.out.println(getAll());
        }
    }


}





