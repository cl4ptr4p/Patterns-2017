# Patterns-2017


## Домашнее задание № 1
### Задача 1
Класс, представляющий простой односвязный список, описан следующим образом:
```
public class List<E extends Comparable<E>> {
    private static class Node<E> {
        E info;
        Node<E> next;
    }
    Node<E> head = null;
    ...
}
```
Требуется дополнить определение класса двумя публичными методами:
`public void swap(int i, int j) { ... }` - переставляет в списке местами два элемента с номерами i и j. Нумерация элементов списка - начиная с нуля. Номера могут идти в любом порядке, то есть может быть как i < j, так и j < i. Если i == j, то список не меняется. Если хотя бы один из индексов выходит за границу списка (меньше нуля или больше или равен числу элементов списка), то должно возникать прерывание IndexOutOfBoundsException.
`public void sort() { ... }` - упорядочивает элементы списка в порядке возрастания (в соответствии с порядком, определенным интерфейсом Comparable). Не нужно изобретать сложные алгоритмы сортировки, для списков самым подходящим будет алгоритм простых вставок.
В обоих методах не надо создавать копии узлов списка, все манипуляции должны происходить только с указателями.

Содержимое узлов менять нельзя! Перестановка элементов в списке осуществляется только за счет того, что меняются ссылки из одних узлов на другие.
### Задача 2
Интерфейс, представляющий простой односвязный циклический список, описан следующим образом:
```
public interface CycList<E> extends Iterable<E>{
    void shift(int delta);
}
```
Функция shift должна сдвигать указатель циклического списка на заданное количество элементов вперед по списку.

Требуется реализовать этот интерфейс и написать еще одну функцию (не метод класса!), которая, используя заданный интерфейс, проверяет, совпадают ли два заданных списка покомпонентно, то есть содержат ли они одни и те же элементы с точностью до сдвига. Например, если списки содержат элементы [1, 2, 3, 4, 5] и [3, 4, 5, 1, 2], то они равны, а если [1, 2, 3, 4, 5] и [5, 4, 3, 2, 1], - то не равны. Равенство элементов списков понимается в смысле метода equals.

Функция должна иметь следующий заголовок:
`static <E> boolean listsEqual(CycList<E> list1, CycList<E> list2) { … }`
Расширять заданный интерфейс дополнительными функциями нельзя, но в реализации, конечно, можно добавлять какие угодно функции для создания списка, вывода его элементов и т.п.


## Домашнее задание № 2
### Задача
Интерфейс имеет следующее описание.
```
public interface Sequence<E> {
    void print(String delimiter, PrintStream ps);
    int size();
}
```
и предназначен для описания последовательностей объектов, строковые представления которых можно вывести в выходной поток, разделенные заданным разделителем. Например, реализующий этот интерфейс объект может содержать массив или список целых, и его метод print может выводить на консоль элементы списка, разделяя их запятыми, с помощью вызова myList.print(", ", System.out).
Используя шаблон проектирования Decorator, реализуйте следующие способы “украшения” результата вывода:
заключение результата вывода в “скобки”, заданные параметрами декоратора;
вывод заголовка перед выводом элементов. Заголовок задается декоратором;
вывод общего количества элементов последовательности после вывода всех элементов.
Пример:
Объект, реализующий интерфейс Sequence, содержит массив целых:
```
public class MyArray implements Sequence<Integer> {
    private Integer[] array;
    public MyArray(Integer... elements) { ... }
    public int size() { return array.length; }
    public void print(String delimiter, PrintStream ps) { ... }
}
```
Вызов метода `new MyArray(1,2,3,4,5).print(", ", System.out)` приведет к выводу на консоль следующей строки:

1, 2, 3, 4, 5
Определенные вами декораторы должны позволять выводить этот же массив в виде

[1, 2, 3, 4, 5]

Элементы: 1;2;3;4;5 всего 5 элементов

Элементы: { 1, 2, 3, 4, 5 }

и так далее.



## Домашнее задание № 3
### Задача 1
Интерфейс дека (очереди с двумя концами) имеет следующее описание:
```
interface Deque<E> extends Iterable<E> {
  void addFirst(E elem);   // Добавляет элемент в начало очереди.
  E first();               // Выдает первый элемент очереди.
  E removeFirst();         // Удаляет первый элемент из очереди
                           // (и выдает его).
  void addLast(E elem);    // Добавляет элемент в конец очереди.
  E last();                // Выдает последний элемент очереди.
  E removeLast();          // Удаляет последний элемент из очереди
                           // (и выдает его).
}
```
Надо написать две реализации этого интерфейса - в виде массива элементов (ArrayDeque) и в виде списка  (ListDeque). Программа запускается с параметрами - имя класса реализации и (для реализации в виде массива) максимальный размер дека. Программа должна динамически загрузить класс с нужной реализацией, создать дек из целых чисел, заполнить его несколькими случайными элементами, вычислить сумму элементов дека, используя итератор, а затем проверить, есть ли в загруженной реализации дополнительный реализованный метод size (вычисляющий число элементов в очереди). Если такой метод есть, то программа должна его вызвать и вывести общее число добавленных элементов; если нет - сообщить об отсутствии метода в реализации.
### Задача 2
Класс содержит описания методов сортировки массива объектов разными способами. Каждый метод имеет стандартный интерфейс вида
`public static <E extends Comparable<E>> void sort(E[] array)`
где sort - имя метода. Реализовать три разных метода сортировки (например, “простыми вставками”, “слиянием”, “быстрая”, можно выбрать любые свои, лишь бы интерфейс метода был таким, как заявлено). Написать программу, которая получает в качестве аргумента название метода, создает случайный массив объектов, а затем сортирует указанным методом.

