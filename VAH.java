import java.lang.Math;

class VAH{
  private static final int N = 21;
  private static final int M = 8;

  public static void main(String[] args){
    double[][] cell = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 4, 68, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 47, 0, 0, 0, 8, 79, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 37, 4, 0, 5, 56, 0, 5, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 91, 182, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 10, 40, 211, 0, 34, 23, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 31, 0, 20, 35, 0, 1, 57, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 19, 0, 10, 44, 0, 8, 7, 134, 4, 4, 8, 3, 7, 0},
                       {0, 0, 0, 0, 0, 0, 4, 1, 26, 2, 15, 6, 9, 0, 350, 535, 22, 18, 1, 1, 0},
                       {0, 0, 1, 24, 27, 0, 8, 33, 7, 66, 11, 6, 7, 0, 7, 16, 16, 33, 18, 0, 0},
                       {0, 0, 0, 1, 8, 8, 0, 6, 0, 4, 40, 7, 0, 0, 0, 2, 0, 13, 53, 14, 0},
                       {0, 0, 0, 1, 0, 0, 3, 7, 1, 0, 0, 0, 34, 0, 7, 0, 9, 5, 40, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
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
    double k = 0.002;
    double l = 0.0009;
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
