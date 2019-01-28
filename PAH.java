import java.lang.Math;

class PAH{
  private static final int N = 13;
  private static final int M = 8;

  public static void main(String[] args){
    double[][] cell = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 132, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 20, 0, 2, 0, 6, 5, 7, 7, 84, 8, 0, 0},
                       {0, 50, 26, 0, 3, 0, 0, 145, 20, 310, 0, 17, 0},
                       {0, 0, 0, 12, 11, 0, 2, 0, 14, 467, 171, 0, 0},
                       {0, 29, 107, 0, 0, 13, 33, 9, 47, 39, 0, 0, 0},
                       {0, 108, 0, 34, 21, 84, 0, 33, 181, 143, 68, 0, 0},
                       {0, 152, 1894, 158, 0, 119, 23, 20, 603, 292, 0, 63, 0},
                       {0, 0, 0, 0, 0, 0, 39, 11, 256, 600, 26, 0, 0},
                       {0, 15, 97, 0, 37, 8, 1, 43, 599, 276, 709, 4664, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    for(int i = 0; i < M; i++){
      ca(cell);
    }

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N - 1; j++){
        System.out.print(cell[i][j] + "\t");
      }
      System.out.println(cell[i][N - 1]);
    }

  }

  public static void ca(double[][] cell){
    for(int row = 1; row < N - 1; row ++){
      for(int col = 1; col < N - 1; col++){
        double left = cell[row][col - 1];
        double up = cell[row - 1][col];
        double right = cell[row][col + 1];
        double down = cell[row + 1][col];
        double upleft = cell[row - 1][col - 1];
        double upright = cell[row - 1][col + 1];
        double downleft = cell[row +1][col - 1];
        double downright = cell[row + 1][col + 1];
        double middle = cell[row][col];

        double newstate = rule(left, right, down, up, upleft, upright, downleft, downright, middle);
        cell[row][col] = newstate;
      }
    }
  }

  public static double rule(double left, double right, double down, double up, double upleft, double upright, double downleft, double downright, double middle){
    double k = 0.0002;
    double l = 0.00009;
    double state = 0;

    if(middle > 20){
      state = 1.038 * middle + k * (up + down + right + left) + l * (upleft + upright + downleft + downright);
    } else {
      state = middle + k * (up + down + right + left) + l * (upleft + upright + downleft + downright);
    }

    /*if(state >= 25){
      return 1;
    } else {
      return 0;
    }*/

    return Math.ceil(state);
  }
}
