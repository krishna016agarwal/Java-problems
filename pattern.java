
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

  public static void rightPyramid(int n) {
    for (int i = 1; i <= 2 * n - 1; i++) {
      int spaces = Math.abs(n - i);
      int stars = n - spaces;
      // for (int j = 0; j < stars; j++) {
      // System.out.print("*");
      // }
      System.out.print("*".repeat(stars));
      System.out.println();
    }
  }

  public static void number_empty_triangle_rectangle(int n) {
    for (int i = 1; i <= n; i++) {
      int spaces = 2 * n - 2 * i;
      for (int j = 1; j <= i; j++) {
        System.out.print(j);
      }
      System.out.print(" ".repeat(spaces));
      for (int j = i; j > 0; j--) {
        System.out.print(j);
      }
      System.out.println();
    }
  }

  public static void numberTriangle(int n) {
    int i = 1;
    for (int j = 1; j <= n; j++) {
      for (int j2 = 0; j2 < j; j2++) {
        System.out.print(i + " ");
        i++;
      }
      System.out.println();
    }
  }

  public static void alphabetTriangle(int n) {

    for (int j = 1; j <= n; j++) {
      for (int j2 = 0; j2 < j; j2++) {
        System.out.print((char) ('A' + j2) + " ");

      }
      System.out.println();
    }
  }

  public static void alphabetPyramid(int n) {
    for (int i = 1; i <= n; i++) {
      int spaces = n - i;
      System.out.print(" ".repeat(spaces)); // print spaces
      int val = 2 * i - 1;
      for (int j = 1; j <= val; j++) {
        if (j < (val / 2 + 1)) {
          System.out.print((char) ('A' + (j - 1)));
        } else {
          System.out.print((char) ('A' + (val - j)));
        }
      }
      System.out.println();
    }
  }

  public static void alphabetInvertedTriangle(int n) {
    for (int i = n; i > 0; i--) {
      for (int j = 0; j < n - i + 1; j++) {
        System.out.print((char) ('A' + i + j - 1));
      }
      System.out.println();
    }
  }

  public static void diamonFrame(int n) {
    int k = 2 * n;
    for (int i = k; i > 0; i--) {

      int con = (k - i) * 2;
      int spaces;

      // logic
      if (con == k) {
        spaces = con - 2;
      } else if (i > n) {
        spaces = con;
      } else {
        spaces = i * 2 - 2;
      }
      int stars = k - spaces;

      int halfFill = stars / 2;
      for (int l = 0; l < halfFill; l++) {
        System.out.print("*");
      }

      System.out.print(" ".repeat(spaces));

      for (int l = 0; l < halfFill; l++) {
        System.out.print("*");
      }

      System.out.println();
    }
  }

  public static void butterfly(int n) {
    int k = 2 * n;
    for (int i = 1; i < k; i++) {
      int spaces = k / 2 > i ? k - 2 * i : 2 * i - k; // condition
      int stars = k - spaces;
      for (int j = 0; j < stars / 2; j++) {
        System.out.print("*");
      }
      System.out.print(" ".repeat(spaces));
      for (int j = 0; j < stars / 2; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  static class snakePattern {
    public static void drawtoRight(int arr[][], int i, int j) {

      if (j == arr.length) {
        return;
      }
      System.out.print(arr[i][j] + " ");
      drawtoRight(arr, i, j + 1);
    }

    public static void drawtoLeft(int arr[][], int i, int j) {
      if (j == -1) {
        return;
      }
      System.out.print(arr[i][j] + " ");
      drawtoLeft(arr, i, j - 1);
    }

    public static void snakePattern(int arr[][], int i, int j) {
      if (i == arr.length) {
        return;
      }

      if (i % 2 == 0) {

        drawtoRight(arr, i, 0);
      } else {
        drawtoLeft(arr, i, arr.length-1);
      }

      snakePattern(arr, i + 1, j);

    }
  }

  public static void main(String[] args) {

    // draw_number_rectangle(3);
    // triangle_of_number(5);
    // diamond(3);
    // diamond2(2);
    // diamond3(2);
    // rightPyramid(5);
    // number_empty_triangle_rectangle(5);
    // numberTriangle(5);
    // alphabetTriangle(5);
    // alphabetPyramid(5);
    // alphabetInvertedTriangle(5);
    // diamonFrame(5);
    // butterfly(5);

    // int arr[][] = { { 10, 20, 30, 40 }, { 50, 60, 70, 80, }, { 27, 29, 47, 48 }, { 32, 33, 39, 50 } };
    // snakePattern.snakePattern(arr, 0, 0);
  }
}
