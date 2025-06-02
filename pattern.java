
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

  public static void main(String[] args) {

    // draw_number_rectangle(3);
    // triangle_of_number(5);
  }
}
