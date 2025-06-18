
public class pattern {

  public static void draw_number_rectangle(int n) {
    for (int i = 0; i < 2 * n - 1; i++) {
      for (int j = 0; j < 2 * n - 1; j++) {
        int min = Math.min(Math.min(i, j), Math.min(2 * n - 2 - j, 2 * n - 2 - i));
        System.out.print(n - min + " ");
      }
      System.out.println();
    }

  }

  public static void triangle_of_number(int n) {
    int arr[][] = new int[n][n];
    int min = 1;
    int max = (n * (n + 1)) / 2;
    int row = 0;
    int col = n;
    while (min <= max) {
      for (int i = row, j = 0; i < n && j < col; i++, j++) {
        arr[i][j] = min;
        min++;
      }
      row++;
      col--;
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public static void diamond(int n) { // O(n^2)
    // top
    for (int i = 0; i < n; i++) {
      // spaces
      for (int j = 0; j < n - i; j++) {
        System.out.print(" ");
      }
      // stars
      for (int k = 0; k < 2 * i + 1; k++) {
        System.out.print("*");
      }
      // spaces
      for (int l = 0; l < n - i; l++) {
        System.out.print(" ");
      }
      System.out.print("\n");
    }
    // bottom

    for (int i = n; i > 0; i--) {
      // spaces
      for (int j = n - i; j >= 0; j--) {
        System.out.print(" ");
      }
      // stars
      for (int k = 2 * (i - 1) + 1; k > 0; k--) {
        System.out.print("*");
      }
      // spaces
      for (int j = n - i; j >= 0; j--) {
        System.out.print(" ");
      }
      System.out.print("\n");
    }
  }

  public static void diamond2(int n) { // O(n^2)

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < 2 * (i + 1) - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = 2 * (n - i - 1) - 1; j > 0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void diamond3(int n) {
    int totalRows = 2 * n - 1;
    for (int i = 0; i < totalRows; i++) {
      int spaces = Math.abs(n - 1 - i);
      int stars = totalRows - 2 * spaces;

      for (int j = 0; j < spaces; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < stars; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    // draw_number_rectangle(3);
    // triangle_of_number(5);
    // diamond(3);
    // diamond2(2);
    // diamond3(2);
  }
}
