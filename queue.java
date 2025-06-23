import java.util.*;

public class queue {

    static class ArrayQueue {
        static int size;
        static int arr[];
        static int rear;

        ArrayQueue(int n) {
            arr = new int[n];
            rear = -1;
            size = n;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int data) { // O(1)
            if (rear == size - 1) {
                return;
            }
            rear = rear + 1;
            arr[rear] = data;

        }

        public static int remove() { // O(n) //1>2>3>4
            if (isEmpty()) { // 2>3>4
                System.out.println("empty"); // 3>4
                return -1; // 4
                // position of each ele is changing so time complexity is O(n)
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];

            }
            rear--;
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            return arr[0];
        }
    }

    static class RotatedArrayQueue {
        static int size;
        static int arr[];
        static int rear;
        static int front;

        RotatedArrayQueue(int n) {
            arr = new int[n];
            rear = -1;
            size = n;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int data) { // O(1)
            if (isFull()) {
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        public static int remove() { // O(1)
            if (isEmpty()) {
                System.out.println("empty");
                return -1;

            }
            int result = arr[front];

            // last ele delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            return arr[front];
        }

    }

    static class LinkedListQueue {
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        static Node head = null;
        static Node tail = null;
        static int size = 0;

        public static void add(int data) { // O(n)
            size++;
            Node a = new Node(data);
            if (isEmpty()) {
                head = tail = a;

                return;
            }

            tail.next = a;
            tail = a;

        }

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static int remove() { // O(n)
            size--;

            if (isEmpty()) {
                return -1;
            }
            if (head.next == null) {
                int a = head.data;
                head = tail = null;
                return a;
            }
            int a = head.data;
            head = head.next;
            return a;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

  
    public static void main(String args[]) {
        // ArrayQueue s=new ArrayQueue(5) //non static method

        // new ArrayQueue(5); // static method
        // ArrayQueue.add(0);
        // ArrayQueue.add(5);
        // ArrayQueue.add(6);
        // while (!ArrayQueue.isEmpty()) {
        // System.out.println(ArrayQueue.peek());
        // ArrayQueue.remove();
        // }

        // ----------------------------------------------------------------

        // new RotatedArrayQueue(3);

        // RotatedArrayQueue.add(1);
        // RotatedArrayQueue.add(2);
        // RotatedArrayQueue.add(3);
        // RotatedArrayQueue.remove();
        // RotatedArrayQueue.add(4);

        // while (!RotatedArrayQueue.isEmpty()) {
        // System.out.println(RotatedArrayQueue.peek());
        // RotatedArrayQueue.remove();
        // }
        
        // ------------------------------------------------------------------------

        // new LinkedListQueue();

        // LinkedListQueue.add(1);
        // LinkedListQueue.add(2);
        // LinkedListQueue.add(3);
        // LinkedListQueue.add(4);
        // LinkedListQueue.add(5);
        // while (!LinkedListQueue.isEmpty()) {
        // System.out.println(LinkedListQueue.peek());
        // LinkedListQueue.remove();
        // }

        // ------------------------------------------------

        // Queue<Integer> q=new LinkedList<>(); 
        // q.add(1);//O(n)
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        //     System.out.println(q.peek()); //O(n)
        //     q.remove();//O(n)
        // }

        //  Queue<Integer> s=new ArrayDeque<>(); //ArrayDeque
        // s.add(1);
        // s.add(2);//O(n)
        // s.add(3);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());//O(n)
        //     s.remove();//O(n)
        // }

    

    }
}
