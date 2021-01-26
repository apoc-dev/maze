public class App {
    public static void main(String[] args){

        int size = 10;

        MazeGenerator generator = new MazeGenerator(size);
        generator.dfs();

        MazeProcessor proc = new MazeProcessor(generator.getList(), generator.getSize());
        proc.toBinary();
        
        int[][] board = proc.getListBinary();

        Maze m = new Maze(board, 1, 1, board.length-2, board.length-2);
        if(m.solve()){
            m.printboard();
        }else{
            System.out.println("no solution");
            m.printboard();
        }

    }
}
