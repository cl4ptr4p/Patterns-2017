import java.util.Iterator;

public class Patterns1 {
    static <E> boolean listsEqual(CycList<E> list1, CycList<E> list2){
        Iterator<E>it1 = list1.iterator();
        Iterator<E>it2 = list2.iterator();
        int size1 = 0;
        int size2 = 0;
        int i = 0;
        boolean local_flag = true;
        while(it1.hasNext()){
            System.out.println(it1.next().toString());
            size1++;
        }
        System.out.println("__________-");
        while(it2.hasNext()){
            System.out.println(it2.next().toString());
            size2++;
        }
        if(size1 != size2){
            return false;
        }
        while(i < size1){
            it1 = list1.iterator();
            it2 = list2.iterator();
            while (it1.hasNext()){
                local_flag = true;
                if(!it1.next().toString().equals(it2.next().toString())){
                    local_flag = false;
                    break;
                }
            }
            if(local_flag){
                return true;
            }
            list1.shift(1);
            i++;
        }
        return false;
    }

    public static void main(String args[]){
        List<Integer> integerList = new List<>();
        integerList.add(5);
        System.out.println(integerList.getSize());
        integerList.add(2);
        integerList.add(5);
        integerList.add(6);
        integerList.add(1);

        System.out.println(integerList.getAll());

        integerList.swap(0,1);

        System.out.println(integerList.getAll());
        System.out.println(integerList.head());
        System.out.println(integerList.tail());

        integerList.swap(1,2);
        System.out.println(integerList.getAll());

        integerList.swap(0,2);
        System.out.println(integerList.getAll());

        integerList.swap(0,4);
        System.out.println(integerList.getAll());

        integerList.swap(1,3);
        System.out.println(integerList.getAll());

        System.out.println("--------------");

        integerList.sort();

        System.out.println(integerList.getAll());
        integerList.remove(3);
        System.out.println(integerList.getAll());
        integerList.remove(2);
        System.out.println(integerList.getAll());
        integerList.remove(2);
        System.out.println(integerList.getAll());
        integerList.remove(1);
        System.out.println(integerList.getAll());
        integerList.remove(0);
        System.out.println(integerList.getAll());

        List<String> stringList = new List<>();

        stringList.add("aaa");
        stringList.add("bbbaaa");
        stringList.add("acfdaa");
        stringList.add("bbb");
        stringList.add("ZAER");
        stringList.add("AbC");
        stringList.add("X");
        stringList.add("3a");
        stringList.add("aa9");

        System.out.println(stringList.getAll());
        stringList.sort();
        System.out.println(stringList.getAll());


        CycleList<Integer>integerCycList = new CycleList<Integer>();
        integerCycList.add(5);
        integerCycList.add(6);
        integerCycList.addInto(1, 1);
        integerCycList.add(3);
        integerCycList.add(88);
        integerCycList.add(52);
        integerCycList.shift(1);
        System.out.println(integerCycList.getAll());
        integerCycList.shift(3);
        System.out.println(integerCycList.getAll());
        integerCycList.shift(11);
        System.out.println(integerCycList.getAll());
        integerCycList.remove(0);
        System.out.println(integerCycList.getAll());
        integerCycList.remove(1);
        System.out.println(integerCycList.getAll());
        System.out.println(integerCycList.getAll());
        integerCycList.remove(0);
        System.out.println(integerCycList.getAll());
        integerCycList.remove(1);
        System.out.println(integerCycList.getAll());
        integerCycList.add(5);
        integerCycList.add(5);
        integerCycList.remove(0);
        integerCycList.add(6);
        integerCycList.add(7);
        integerCycList.add(8);

        System.out.println("-------------");
        CycleList<Integer>anotherIntegerCycList = new CycleList<>();
        anotherIntegerCycList.add(6);
        anotherIntegerCycList.add(7);
        anotherIntegerCycList.add(8);
        anotherIntegerCycList.add(5);
        anotherIntegerCycList.add(5);

        System.out.println(listsEqual(integerCycList, anotherIntegerCycList));

    }

}
