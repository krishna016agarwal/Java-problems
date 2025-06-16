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
            size = 0;
            head = tail = null;
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }

    public void search(int ele) { // O(n)
        if (size == 0) {
            System.out.println("LinkList is empty");
            return;
        }
        int i = 0;
        Node temp = head;

        while (temp.data != ele) {
            i++;
            temp = temp.next;
            if (temp == null) {
                System.out.println("Not found");
                return;
            }
        }

        System.out.println(i);
    }

    static class resSearch { // O(n) space- O(n)
        public int helper(Node head, int key) { // O(n)
            if (head == null) {
                return -1;
            }
            if (head.data == key) {
                return 0;
            }
            int idx = helper(head.next, key);
            if (idx == -1) {
                return -1;
            }
            return idx + 1;
        }

        public int recursiveSearch(int key) {
            return helper(head, key);
        }
    }

    public void reverse() { // O(n)
        Node pre = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;

    }

    public void remove_Nth_node_from_end(int n) { // O(n)
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }
        if (n == sz) {
            head = head.next;
            return;
        }
        if (n == 0 || n > sz) {
            System.out.println("Invalid index");
            return;
        }
        int i = 1;
        Node pre = head;
        while (i < sz - n) {
            pre = pre.next;
            i++;
        }
        pre.next = pre.next.next;

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

        ll.search(1);

        linkedList.resSearch r = new resSearch(); // if resSearch is static
        // linkedList.resSearch r=ll.new resSearch(); //if resSearch is not static
        System.out.println(r.recursiveSearch(1));

        // ll.reverse();
        // ll.printLinkList();
        ll.addLast(16);
        ll.printLinkList();
        ll.remove_Nth_node_from_end(3);
        ll.printLinkList();

    }
}