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

    static class make_Queue_using_two_stack {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) { // O(n)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() { // O(1)
            if (s1.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (s1.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return s1.peek();
        }
    }

    static class make_stack_using_two_queue {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void add(int data) { // O(1)
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }

        }

        public static int pop() { // O(n)
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }

            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }

            }
            return top;
        }

        public static int peek() { // O(n)
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();

                    q2.add(top);
                }

            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();

                    q1.add(top);
                }

            }
            return top;
        }
    }

    public static void non_repeating_letters_in_a_stream_of_characters(String str) {

        int fre[] = new int[26]; // a-z
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            fre[a - 'a']++; // 'a' - 'a' → 0 / 'b'- 'a' → 1 / 'c'- 'a' → 25

            q.add(a);

            while (!q.isEmpty() && fre[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }

        }
        System.out.println();
    }

    public static void Interleave_2_halve_for_a_queue_even_length(Queue<Integer> q) { //time-O(n) space-O(n)
        int size = q.size();

        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < size / 2; i++) {
            q2.add(q.remove());
        }

        // q=[1,2,3,4,5,6,7,8,9,10] --> q2=[1,2,3,4,5] q=[6,7,8,9,10]
       
        while (!q2.isEmpty()) {
            q.add(q2.remove());
            q.add(q.remove());

        }

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }

   public static void reverse_Queue(Queue<Integer> q){
    
    Stack<Integer> s=new Stack<>();
       while (!q.isEmpty()) {
        s.add(q.remove());
       }
       while (!s.isEmpty()) {
        q.add(s.pop());
       }
       while (!q.isEmpty()) {
        System.out.print(q.remove()+" ");
       }
   }
    
   static class make_stack_using_deque{
   static Deque<Integer> s=new LinkedList<>();

    public static boolean isEmpty(){
          return s.isEmpty();
    }
    public static void add(int data){
          s.addLast(data);
    }
    public static int pop(){
        if (isEmpty()) {
            System.out.println("empty");
            return -1;
        }
        return s.removeLast();
    }
    public static int peek(){
         if (isEmpty()) {
            System.out.println("empty");
            return -1;
        }
        return s.getLast();
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
        // System.out.println(q.peek()); //O(n)
        // q.remove();//O(n)
        // }
        // -----------------------------------------------------------------
        // Queue<Integer> s=new ArrayDeque<>(); //ArrayDeque
        // s.add(1);
        // s.add(2);//O(n)
        // s.add(3);
        // while (!s.isEmpty()) {
        // System.out.println(s.peek());//O(n)
        // s.remove();//O(n)
        // }

        // ---------------make_Queue_using_two_stack------------------------

        // new make_Queue_using_two_stack();
        // make_Queue_using_two_stack.add(1);
        // make_Queue_using_two_stack.add(2);
        // make_Queue_using_two_stack.add(3);
        // make_Queue_using_two_stack.add(4);
        // while (!make_Queue_using_two_stack.isEmpty()) {
        // System.out.println(make_Queue_using_two_stack.peek());
        // make_Queue_using_two_stack.remove();
        // }

        // -------------------make_stack_using_two_queue------------------------------------

        // new make_stack_using_two_queue();
        // make_stack_using_two_queue.add(1);
        // make_stack_using_two_queue.add(2);
        // make_stack_using_two_queue.add(3);
        // while (!make_stack_using_two_queue.isEmpty()) {
        // System.out.println(make_stack_using_two_queue.peek());
        // make_stack_using_two_queue.pop();
        // }

        // -----------------------------------------

        // String str="aabccxb";
        // non_repeating_letters_in_a_stream_of_characters(str);

        // ---------------Interleave_2_halve_for_a_queue_even_length------------------

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        // Interleave_2_halve_for_a_queue_even_length(q);

        //-----------------Reverse Queue-------------------------------

        //   Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        // reverse_Queue(q);

        //-----------------------------

        // Deque<Integer> q=new LinkedList<>();
        // q.addFirst(1);
        // q.addFirst(2);
        // System.out.println(q);
        // q.removeFirst();
        // System.out.println(q);

        //--------make_stack_using_deque------------------------------

        // new make_stack_using_deque();
        // make_stack_using_deque.add(1);
        // make_stack_using_deque.add(2);
        // make_stack_using_deque.add(3);
        // while (!make_stack_using_deque.isEmpty()) {
        //     System.out.println(make_stack_using_deque.peek());
        //     make_stack_using_deque.pop();
        // }
    }
}
