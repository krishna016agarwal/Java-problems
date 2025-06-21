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

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            char a = str.charAt(idx);
            s.push(a);
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }

    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void nextGreaterElement(int arr[]) { // O(n)
        Stack<Integer> s = new Stack<>();
        int nextArr[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {

                s.pop();
            }
            if (s.isEmpty()) {
                nextArr[i] = -1;
            } else {
                nextArr[i] = s.peek();
            }

            s.push(arr[i]);

        }

        for (int i = 0; i < nextArr.length; i++) {
            System.out.print(nextArr[i] + " ");
        }

    }

    public static boolean isValid(String str) { // O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && str.charAt(i) == ')')
                        || (s.peek() == '{' && str.charAt(i) == '}')
                        || (s.peek() == '[' && str.charAt(i) == ']')) {
                    s.pop();
                }
            }

        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean duplicateParentheses(String str) { // O(n)
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            // closing
            if (str.charAt(i) == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate exist
                }
                s.pop(); // opening pair

            }
            if (str.charAt(i) != ')') {
                // opening
                s.push(str.charAt(i));
            }
        }
        return false;
    }

    public static void max_area_in_histogram(int arr[]) { // O(n)
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();

            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // next smaller left
        s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();

            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // current area
        // width=j-i-1=nsr[i]/-nsl[i]-1
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currAea = height * width;
            maxArea = Math.max(currAea, maxArea);
        }
        System.out.println("max area in histogram = " + maxArea);
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
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // while (!s.isEmpty()) {
        // System.out.print(s.peek()+" ");
        // s.pop();
        // }

        // pushAtBottom(s, 5);
        // while (!s.isEmpty()) {
        // System.out.print(s.peek() + " ");
        // s.pop();
        // }
        // -------------------Reverse String -------------------------
        // String str="hello world";
        // String a=reverseString(str);
        // System.out.println(a);

        // -----------------reverse Stack---------------
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);

        // reverseStack(s);
        // print(s);

        // int arr[] = { 6, 8, 0, 1, 3 };
        // nextGreaterElement(arr);

        // String str="()({[]})[]";
        // System.out.println(isValid(str));

        // String str="((c+d))"; //valid string
        // String str1="(a+b)";
        // System.out.println(duplicateParentheses(str));

        // int arr[]={2,1,5}; //height in histogram
        // max_area_in_histogram(arr);
    }
}
