public class doubleLinkedList {

    public class Node {
        int data;
        Node next;
        Node pre;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public void addFirst(int data) {
        size++;
        Node a = new Node(data);
        if (head == null) {
            head = tail = a;
            return;
        }

        a.next = head;
        head.pre = a;
        a.pre = null;
        head = a;
    }

    // print
    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // remove last
    public static void removeLast() {
        if (head == null) {
            System.out.println("empty ll");
            return;
        }
        if (head.next == null) {
            size--;
            head = tail = null;
            return;
        }
        size--;
        tail.pre.next = null;

        tail = tail.pre;

    }

    public static void removeFirst() {
        if (head == null) {
            System.out.println("empty ll");
            return;
        }
        if (head.next == null) {
            size--;
            head = tail = null;
            return;
        }
        head.next.pre = null;
        head = head.next;
        size--;
    }

    public static void reverse() {
        Node pre = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            curr.pre = next;
            pre = curr;
            curr = next;
        }
        head = pre;
    }

    public static void circularlist() {
        if (head == null || head.next == null) {
            return;
        }
        tail.next = head;
        head.pre = tail;
    }

    public static void printCircularList() {
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String args[]) {
        doubleLinkedList dll = new doubleLinkedList();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        print();

        // removeLast();
        // removeLast();
        // print();

        // removeFirst();
        // print();
        // System.out.println("size- "+size);

        // reverse();
        // print();

        // circularlist();
        // printCircularList();
    }
}
