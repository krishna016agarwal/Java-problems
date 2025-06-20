import java.util.*;

public class stack {
    static class stackB {
        static ArrayList<Integer> a = new ArrayList<>();

        public static boolean isEmpty() { // O(1)
            if (a.size() == 0) {
                return true;
            }
            return false;
        }

        public static void push(int data) {// O(1)
            a.add(data);
        }

        public static int pop() {// O(1)
            if (isEmpty()) {
                return -1;
            }
            int top = a.get(a.size() - 1);
            a.remove(a.size() - 1);
            return top;
        }

        public static int peek() {// O(1)
            if (isEmpty()) {
                return -1;
            }
            return a.get(a.size() - 1);
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stackll {
        static Node head = null;

        public static boolean isEmpty() {// O(1)
            return head == null;
        }

        public static void push(int data) {// O(1)
            Node a = new Node(data);
            if (head == null) {
                head = a;
                return;
            }

            a.next = head;
            head = a;
        }

        public static int pop() {// O(1)
            if (head == null) {
                return -1;
            }
            int h = head.data;
            head = head.next;
            return h;
        }

        public static int peek() {// O(1)
            if (head == null) {
                return -1;
            }
            return head.data;
        }

    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;

        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void main(String args[]) {
        // ----------array list stack--------- //O(1)
        // stackB.push(1);
        // stackB.push(2);
        // stackB.push(3);
        // stackB.push(4);
        // while (!stackB.isEmpty()) {
        // System.out.println(stackB.peek());
        // stackB.pop();
        // }

        // -----------linked list stack-----------
        // stackll.push(4);
        // stackll.push(3);
        // stackll.push(2);
        // stackll.push(1);
        // while (!stackll.isEmpty()) {
        // System.out.print(stackll.peek()+" ");
        // stackll.pop();
        // }

        // ------------Java collection framework Stack-----------
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        // while (!s.isEmpty()) {
        // System.out.print(s.peek()+" ");
        // s.pop();
        // }

        pushAtBottom(s, 5);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
}
