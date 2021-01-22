public class App {
    public static void main(String[] args){

        int[][] board = {{0,0,0,1,0,0,0,1},
                         {1,1,0,1,0,1,0,1},
                         {1,0,0,1,0,1,0,1},
                         {1,0,1,1,0,1,0,1},
                         {1,0,0,0,0,1,0,1},
                         {1,1,1,1,1,1,0,1},
                         {0,0,0,1,1,0,0,0},
                         {0,0,0,1,1,0,0,0}};

        Maze m = new Maze(board);
        if(m.solve()){
            m.printboard();
        }else{
            System.out.println("no solution");
            m.printboard();
        }

    }
}
