public class Maze {
    
    int[][] board;
    int[][] sol;

    public Maze(int[][] board){
        this.sol = new int[4][4];
        this.board = board;
    }
    
    public boolean solve(){
        if(backtrack(0,0, sol)){
            return true;
        }
        return false;
    }


    //backtrack
    //base case
    //next step (create id for each field 0-15 rows*col)
    //if correct execute self
    //if wrong write field to null and counter -1 and execute self

    public boolean backtrack(int row, int col, int[][] sol){

        if(row == board.length-1 && col == board.length-1){
            return true;
        }
        
        
        for (int i = 0; i < 1; i++) {
            if(i == 0){
                if(check(row, col+1)){
                    sol[row][col+1] = 1;
                    if(!backtrack(row, col+1, sol)){
                        sol[row][col+1] = 0;
                    }
                }
            }
            if(i == 1){
                if(check(row+1, col)){
                    sol[row+1][col] = 1;
                    if(!backtrack(row+1, col, sol)){
                        sol[row+1][col] = 0;
                    }
                }
            }
        }

        return false;
    }


    public boolean check(int row, int col){
        if(row >= board.length-1){
            return false;
        }
        if(col >= board.length-1){
            return false;
        }

        if (board[row][col] == 0){
            return true;
        }

        return false;
    }
    //checkifok
    //if field is 1 ok
    //if field is 0 not ok

    public void printboard(){
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
            
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    };

}
