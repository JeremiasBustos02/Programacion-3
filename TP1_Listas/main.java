package ProgramacionIII.tp1;

import java.util.Iterator;

public class main {
    public static void main(String[] args) {}

    // Ejercicio 7
    public static <T extends Comparable<T>> MySimpleLinkedList<T> buildList(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Iterator<T> tmp1 = list1.iterator();
        while(tmp1.hasNext()){
            T info = tmp1.next();
            Iterator<T> tmp2 = list2.iterator();
            while (tmp2.hasNext()){
                T info2 = tmp2.next();
                if (info.equals(info2)){
                    result.insertSorted(info);
                }
            }
        }
        return result;
    }

    // Ejercicio 6
    public static <T extends Comparable<T>> MySimpleLinkedList<T> buildTwoList(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
        Iterator<T> tmp1 = list1.iterator();
        while(tmp1.hasNext()){
            T info = tmp1.next();
            boolean found = false;
            // Iterador de tmp2, reinicia
            Iterator<T> tmp2 = list2.iterator();
            while (tmp2.hasNext()){
                T info2 = tmp2.next();
                if (info.equals(info2)){
                    found = true;
                    break;
                }
            }
            // Si no lo encotramos en list2, agregamos a result
            if (!found) {
                result.insertSorted(info);
            }
        }
        return result;
    }
}
