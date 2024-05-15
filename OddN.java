public class OddN {

  public static void main(String[] args) throws RuntimeException {
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
      if (magic[(row + 1) % n][(col + 1) % n] == 0) {
        row = (row + 1) % n;
        col = (col + 1) % n;

      }

      magic[row][col] = i;
    }

  }
}
