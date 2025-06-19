import java.util.LinkedList;

public class JavaCollectionFramework_Linklist {
    public static void main(String args[]) {

        // create-object
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(31);
        ll.addFirst(3);
        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
   

}