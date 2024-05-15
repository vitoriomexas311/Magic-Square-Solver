public class OddN {

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);

    if (n % 2 == 0) {
      throw new RuntimeException("n must be an odd integer");
    }

    // n = columns, rows
    int[][] magic = new int[n][n];

    // row starts as n - 1 to get first row
    int row = n - 1;
    // column we get the middle
    int col = n / 2;

    // Siamese Method

    magic[row][col] = 1; // start with 1 in the middle of the first row
    for (int i = 2; i < n * n; i++) {
      // if we reach a corner
      if (magic[(row + 1) % n][(col + 1) % n] == 0) {
        row = (row + 1) % n;
        col = (col + 1) % n;
        // otherwise, we don't change the column, but go through by row
      } else {
        row = (row - 1 + n) % n;
      }
      magic[row][col] = i;
    }

    // print results
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (magic[i][j] < 10)  System.out.print(" ");  // for alignment
        if (magic[i][j] < 100) System.out.print(" ");  // for alignment
        System.out.print(magic[i][j] + " ");
      }
      System.out.println();
    }
  }
}

