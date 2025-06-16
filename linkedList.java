public class linkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size; // O(1)

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data); // create new node
        size++;
        if (head == null) {
            head = tail = newNode; // if linklist is empty
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLinkList() { // O(n)
        if (head == null) {
            System.out.println("LL is empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void addAtIndex(int index, int data) { // O(n)
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;

        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeFirst() { // O(1)
        if (size == 0) {
            System.out.println("Linklist is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
        }
        head = head.next;
        size--;
    }

    public void removeLast() { // O(n)
        if (size == 0) {
            System.out.println("Linklist is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public static void main(String args[]) {
        linkedList ll = new linkedList();

        ll.addFirst(1);

        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addAtIndex(4, 12);

        ll.printLinkList();
        System.out.println(ll.size);
        ll.removeFirst();
        ll.printLinkList();
        System.out.println(ll.size);
        ll.removeLast();
        ll.printLinkList();
        System.out.println(ll.size);
    }
}