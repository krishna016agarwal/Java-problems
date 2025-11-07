import java.util.*;

public class stack {
    static class stack_using_arraylist {
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

    static class stack_using_linkedList {
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

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

    static boolean validParenthesis(String s) {
        Stack<Character> a = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char j = s.charAt(i);
            if (a.size() == 0 && (j == ']' || j == '}' || j == ')'))
                return false;
            else if (j == '(' || j == '{' || j == '[')
                a.push(j);
            else if ((j == ')' && a.peek() == '(') || (j == '}' && a.peek() == '{') || (j == ']' && a.peek() == '['))
                a.pop();
            else
                return false;
        }
        return a.size() == 0;
    }

    class InfixToPostfix {
        public static String infixToPostfix(String s) {
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                // Operand
                if (Character.isLetterOrDigit(ch)) {
                    result.append(ch);
                }
                // Opening bracket
                else if (ch == '(') {
                    stack.push(ch);
                }
                // Closing bracket
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop(); // remove '('
                }
                // Operator
                else {
                    while (!stack.isEmpty() &&
                            (precedence(ch) < precedence(stack.peek()) ||
                                    (precedence(ch) == precedence(stack.peek()) && ch != '^'))) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }

            // Pop all remaining operators
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            return result.toString();
        }

        static int precedence(char ch) {
            switch (ch) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }
    }

    static String postfixToInfix(String s) {
        Stack<String> a = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String j = Character.toString(s.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(i))) {
                a.push(j);
            } else {

                String n = a.pop();
                String m = a.pop();
                String q = "(" + m + j + n + ")";
                a.push(q);
            }

        }
        return a.pop();
    }

    static String prefixToInfix(String s) {
        Stack<String> a = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String j = Character.toString(s.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(i))) {
                a.push(j);
            } else {

                String n = a.pop();
                String m = a.pop();
                String q = "(" + n + j + m + ")";
                a.push(q);
            }

        }
        return a.pop();
    }

    static String postfixToPrefix(String s) {
        Stack<String> a = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String j = Character.toString(s.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(i))) {
                a.push(j);
            } else {

                String n = a.pop();
                String m = a.pop();
                String q = j + m + n;
                a.push(q);
            }

        }
        return a.pop();
    }

    static String prefixToPostfix(String s) {
        Stack<String> a = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            String j = Character.toString(s.charAt(i));
            if (Character.isLetterOrDigit(s.charAt(i))) {
                a.push(j);
            } else {

                String n = a.pop();
                String m = a.pop();
                String q = n + m + j;
                a.push(q);
            }

        }
        return a.pop();
    }

    class MinStack { // O(1) SC-O(2*n)
        private Stack<int[]> a;

        public MinStack() {
            a = new Stack<>();
        }

        public void push(int val) {
            int min;
            if (a.isEmpty()) {
                min = val;
            } else {
                min = Math.min(val, a.peek()[1]);
            }
            a.push(new int[] { val, min });
        }

        public void pop() {
            if (!a.isEmpty()) {
                a.pop();
            }
        }

        public int top() {
            return a.peek()[0];
        }

        public int getMin() {
            return a.peek()[1];
        }
    }

    class MinStack_optimal { // SC- O(n) TC - O(1)
        Stack<Long> stack = new Stack<>();
        long min;

        public MinStack_optimal() {
        }

        public void push(int val) {
            long value = val;
            if (stack.isEmpty()) {
                stack.push(value);
                min = value;
            } else {
                if (value < min) {
                    // encode the smaller value
                    stack.push(2 * value - min);
                    min = value;
                } else {
                    stack.push(value);
                }
            }
        }

        public void pop() {
            if (stack.isEmpty())
                return;
            long top = stack.pop();
            if (top < min) {
                // decode previous min
                min = 2 * min - top;
            }
        }

        public int top() {
            long top = stack.peek();
            if (top < min) {
                return (int) min;
            } else {
                return (int) top;
            }
        }

        public int getMin() {
            return (int) min;
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) { // TC - O(m + n) SC - O (n)
        HashMap<Integer, Integer> a = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                a.put(nums2[i], -1);

            } else if (nums2[i] < s.peek()) {
                a.put(nums2[i], s.peek());

            } else if (nums2[i] >= s.peek()) {
                while (!s.isEmpty() && nums2[i] > s.peek()) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    a.put(nums2[i], -1);

                } else {
                    a.put(nums2[i], s.peek());
                }
            }
            s.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = a.get(nums1[i]);
        }
        return nums1;
    }

    public int[] nextGreaterElements_circularArray(int[] nums) { // TC-O(n) SC-O(n)
        Stack<Integer> s = new Stack<>();
        int i = nums.length - 1;
        int[] arr = new int[nums.length];
        int j = 0;
        while (j != 2 * nums.length) {
            while (!s.isEmpty() && nums[i] >= s.peek()) {
                s.pop();
            }
            if (!s.isEmpty()) {
                arr[i] = s.peek();
            } else {
                arr[i] = -1;
            }
            s.push(nums[i]);
            j++;
            i = (i + nums.length - 1) % nums.length;

        }
        return arr;

    }

    public static int trapRainWater(int[] height) { // O(3n) SC- O(2n)
        int total = 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int ll = height[0];
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= ll) {
                ll = height[i];
                left[i] = 0;
            } else {
                left[i] = ll;
            }
        }
        int rl = height[height.length - 1];

        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= rl) {
                rl = height[i];
                right[i] = 0;
            } else {
                right[i] = rl;
            }
        }

        for (int i = 0; i < height.length; i++) {

            if (Math.min(right[i], left[i]) > 0) {
                total += Math.min(right[i], left[i]) - height[i];
            }
        }
        return total;
    }

    public int trapRainWater2(int[] height) { // O(3n) SC- O(n)
        int total = 0;

        int right[] = new int[height.length];

        int rl = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= rl) {
                rl = height[i];
                right[i] = 0;
            } else {
                right[i] = rl;
            }
        }
        int ll = height[0];
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= ll) {
                ll = height[i];
                right[i] = 0;
            } else {
                right[i] = Math.min(ll, right[i]);
            }
        }

        for (int i = 0; i < height.length; i++) {
            if (right[i] > 0) {
                total += right[i] - height[i];
            }
        }
        return total;
    }

    public int trapRainWater_Optimal(int[] height) { // O(n) SC- O(1)
        int total = 0;

        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (lmax > height[l]) {
                    total += lmax - height[l];

                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if (height[r] < rmax) {
                    total += rmax - height[r];

                } else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return total;
    }

    public static void main(String args[]) {
        // ----------array list stack--------- //O(1)
        // stack_using_arraylist.push(1);
        // stack_using_arraylist.push(2);
        // stack_using_arraylist.push(3);
        // stack_using_arraylist.push(4);
        // while (!stack_using_arraylist.isEmpty()) {
        // System.out.println(stack_using_arraylist.peek());
        // stack_using_arraylist.pop();
        // }

        // -----------linked list stack-----------
        // stack_using_linkedList.push(4);
        // stack_using_linkedList.push(3);
        // stack_using_linkedList.push(2);
        // stack_using_linkedList.push(1);
        // while (!stack_using_linkedList.isEmpty()) {
        // System.out.print(stack_using_linkedList.peek()+" ");
        // stack_using_linkedList.pop();
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

        // String str = "(])";
        // System.out.println(validParenthesis(str));

        // String str="((c+d))"; //valid string
        // String str1="(a+b)";
        // System.out.println(duplicateParentheses(str));

        // int arr[]={2,1,5}; //height in histogram
        // max_area_in_histogram(arr);

        // System.out.println(stack.InfixToPostfix.infixToPostfix("(a+b)*(c-d)"));

        // System.out.println(postfixToInfix("ab+cd-*"));

        // System.out.println(prefixToInfix("*+pq-mn"));

        // System.out.println(postfixToPrefix("AB-DE+F*/"));

        // System.out.println(prefixToPostfix("/-AB*+DEF"));

        // int arr[] = {
        // 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        // };
        // System.out.println(trapRainWater(arr));
        // trap(arr);
    }
}
