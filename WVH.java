import java.lang.Math;

class WVH{
  private static final int N = 14;
  private static final int M = 8;

  public static void main(String[] args){
    double[][] cell = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 79, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 27, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 25, 0, 0, 100, 219, 0, 0, 3, 146, 12, 0},
                       {0, 0, 0, 60, 0, 0, 35, 0, 5, 29, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0, 0, 0},
                       {0, 0, 21, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 72, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                       {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    for(int i = 0; i < M; i++){
      ca(cell);
    }

    /*File file = new File("/Users/yshen3/Documents/WVH2010.txt");
    file.getParentFile().mkdirs();
    PrintWriter writer = new PrintWriter(file);*/

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N - 1; j++){
        System.out.print(cell[i][j] + "\t");
        //writer.print(cell[i][j] + " ");
      }
      System.out.println(cell[i][N - 1]);
      //writer.println(cell[i][N - 1]);
    }

    //writer.close();

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
    double k = 0.0005;
    double l = 0.0003;
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

    return Math.floor(state);
    // return state;
  }
}
