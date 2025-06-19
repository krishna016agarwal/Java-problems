
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

    static class is_palindrome {
        // slow-fast approach
        public Node findMid(Node head) { // helper
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next; // +1
                fast = fast.next.next; // +2
            }
            return slow; // slow is my MidNode
        }

        public boolean checkPanlindrome() {
            if (head == null || head.next == null) {
                return true;

            }
            // find midNode
            Node midNode = findMid(head);

            // reverse 2nd half
            Node curr = midNode;
            Node pre = null;
            Node next = curr.next;
            while (curr != null) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;

            }
            Node right = pre;// right half head
            Node left = head;

            // check left half and right half equal or not
            while (right != null) {
                if (left.data != right.data) {
                    return false;
                }
                left = left.next;
                right = right.next;

            }
            return true;
        }
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // first find cycle

        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return;
        }
        // find meet point

        slow = head;
        Node pre = null; // last node
        while (slow != fast) {
            pre = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle last.next=null;
        pre.next = null;

    }

    static class MergeSort {
        Node getMid(Node head) {
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public Node merge(Node head1, Node head2) {
            Node mergeLL = new Node(-1);
            Node temp = mergeLL;
            while (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                    temp = temp.next;
                }

            }
            while (head1 != null) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while (head2 != null) {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergeLL.next;
        }

        public Node mergeSort(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            // find mid
            Node mid = getMid(head);

            // left & right Meergesort
            Node rightHead = mid.next;
            mid.next = null;
            Node newLeft = mergeSort(head);
            Node newRight = mergeSort(rightHead);

            // merge
            return merge(newLeft, newRight);
        }
    }

    public static void zigzag() {
        // finding mid Node

        Node slow = head;

        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half
        Node pre = null;
        Node curr = slow.next;
        slow.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        Node right = pre;
        Node left = head;
        // 1>2>3>4>5>6>null
        // 1>2>3>null //6>5>4>null

        // connecting 2 linkedList

        Node nextleft;
        Node nextright;
        while (right != null && left != null) {
            nextleft = left.next;
            left.next = right;
            nextright = right.next;
            right.next = nextleft;

            left = nextleft;
            right = nextright;

        }

    }

    public static void main(String args[]) {
        // linkedList ll = new linkedList();

        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(1);
        // ll.addLast(2);

        // ll.addAtIndex(4, 12);

        // ll.printLinkList();

        // System.out.println(ll.size);

        // ll.removeFirst();
        // ll.printLinkList();

        // ll.search(1);

        // resSearch r = new resSearch(); // if resSearch is static
        // // linkedList.resSearch r=ll.new resSearch(); //if resSearch is not static
        // System.out.println(r.recursiveSearch(2));

        // ll.reverse();
        // ll.printLinkList();

        // ll.remove_Nth_node_from_end(3);
        // ll.printLinkList();

        // is_palindrome s=new is_palindrome();
        // System.out.println(s.checkPanlindrome());

        // -------------- Remove Cycle-------------------------------
        // head = new Node(1);
        // Node temp = new Node(3);
        // head.next = temp;
        // head.next.next = new Node(2);
        // head.next.next.next = temp;
        // // 1->3->2->3
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // --------------Merge Sort------------------

        // linkedList ll = new linkedList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // //5>4>3>2>1
        // ll.printLinkList();
        // MergeSort r=new MergeSort();
        // ll.head= r.mergeSort(ll.head);
        // ll.printLinkList();

        // ---------------Zig Zag------------------------------

        // linkedList ll = new linkedList();
        // ll.addFirst(6);
        // ll.addFirst(5);
        // ll.addFirst(4);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.printLinkList();
        // ll.zigzag();
        // ll.printLinkList();
//----------------------------------------------------
    }
}
