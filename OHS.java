import java.lang.Math;

class OHS{
  private static final int N = 15;
  private static final int M = 8;

  public static void main(String[] args){
    double[][] cell = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 1, 0, 21, 3, 0, 0, 23, 44, 2, 0, 0, 0, 0},
                       {0, 5, 0, 6, 7, 0, 10, 0, 0, 1, 12, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 6, 2, 0, 5, 13, 8, 0, 0, 0, 0},
                       {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0},
                       {0, 0, 5, 3, 0, 6, 9, 10, 5, 21, 1, 0, 0, 0, 0},
                       {0, 3, 3, 0, 0, 8, 7, 0, 1, 1, 0, 0, 0, 0, 0},
                       {0, 3, 5, 0, 3, 17, 2, 0, 1, 3, 3, 0, 0, 0, 0},
                       {0, 0, 8, 0, 6, 20, 29, 0, 1, 6, 4, 0, 0, 0, 0},
                       {0, 3, 65, 6, 0, 0, 4, 8, 0, 0, 0, 0, 0, 0, 0},
                       {0, 17, 15, 8, 0, 5, 0, 0, 1, 10, 0, 0, 0, 0, 0},
                       {0, 112, 0, 0, 0, 17, 0, 12, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 22, 8, 0, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 6, 14, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
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
    double k = 0.009;
    double l = 0.006;
    double state = 0;

    if(middle > 5){
      state = 1.038 * middle + k * (up + down + right + left) + l * (upleft + upright + downleft + downright);
    } else {
      state = middle + k * (up + down + right + left) + l * (upleft + upright + downleft + downright);
    }

    return Math.ceil(state);
  }
}
