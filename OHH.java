import java.lang.Math;

class OHH{
  private static final int N = 14;
  private static final int M = 8;

  public static void main(String[] args){
    double[][] cell = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 26, 0, 372, 21, 0, 0, 258, 0, 568, 126, 0},
                       {0, 0, 56, 0, 43, 50, 0, 152, 353, 0, 0, 17, 0, 0},
                       {0, 0, 0, 0, 0, 35, 0, 76, 0, 91, 272, 79, 237, 0},
                       {0, 0, 0, 56, 91, 0, 25, 0, 0, 0, 0, 0, 211, 0},
                       {0, 13, 9, 0, 52, 91, 26, 123, 122, 81, 0, 256, 98, 0},
                       {0, 0, 36, 0, 29, 46, 78, 28, 3, 54, 29, 2, 64, 0},
                       {0, 16, 47, 0, 16, 1300, 0, 113, 0, 0, 59, 9, 0, 0},
                       {0, 26, 651, 71, 84, 31, 0, 131, 0, 55, 0, 0, 71, 0},
                       {0, 381, 91, 57, 52, 52, 0, 24, 11, 3, 5, 6, 0, 0},
                       {0, 3970, 0, 0, 23, 67, 0, 5, 96, 0, 73, 0, 0, 0},
                       {0, 0, 232, 37, 41, 17, 0, 64, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 46, 132, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
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
    double k = 0.00025;
    double l = 0.000095;
    double state = 0;

    if(middle > 20){
      state = 1.038 * middle + k * (up + down + right + left) + l * (upleft + upright + downleft + downright);
    } else {
      state = middle + k * (up + down + right + left) + l * (upleft + upright + downleft + downright);
    }

    return Math.ceil(state);
  }
}
