import java.util.Stack;

public class recursion {

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;

        double half = myPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else if (n > 0)
            return half * half * x;
        else
            return half * half / x;
    }

    class Sort_Stack {

        public static Stack<Integer> sort(Stack<Integer> st, int a) {
            if (st.isEmpty() || a > st.peek()) {
                st.push(a);
                return st;
            }
            int b = st.pop();
            sort(st, a);
            st.push(b);
            return st;

        }

        public static void sortStack(Stack<Integer> st) {

            if (st.isEmpty())
                return;

            int a = st.pop();
            sortStack(st);
            sort(st, a);

        }
    }

    class Reverse_Stack {

        public static Stack<Integer> reverse(Stack<Integer> st, int a) {
            if (st.isEmpty()) {
                st.push(a);
                return st;
            }
            int b = st.pop();
            reverse(st, a);
            st.push(b);
            return st;

        }

        public static void reverseStack(Stack<Integer> st) {

            if (st.isEmpty())
                return;

            int a = st.pop();
            reverseStack(st);
            reverse(st, a);

        }
    }

    public static void main(String[] args) {

        // System.out.println(myPow(2, 3));

    }
}
