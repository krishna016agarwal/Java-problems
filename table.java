public class table {
    public static void table(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "*" + i + "=" + n * i);
        }
    }

    public static void number(int n) {
        for (int i = 2; i <= n; i++) {
            table(i);
            System.out.println("\n");
        }

    }

    public static void main(String args[]) {
        number(5);
    }
}
