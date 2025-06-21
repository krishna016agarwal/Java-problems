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

        public static void add(int data) {
            if (rear == size - 1) {
                return;
            }
            rear = rear + 1;
            arr[rear] = data;

        }

        public static void print() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
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

    public static void main(String args[]) {
        // ArrayQueue a =new ArrayQueue(5);
        ArrayQueue.add(0);
        ArrayQueue.add(5);
        ArrayQueue.add(6);
        while (!ArrayQueue.isEmpty()) {
            System.out.println(ArrayQueue.peek());
            ArrayQueue.remove();
        }

    }
}
