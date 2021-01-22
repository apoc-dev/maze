public class Maze {
    
    int[][] board;
    int[][] sol;

    public Maze(int[][] board){
        this.sol = new int[board.length][board.length];
        this.sol[0][0] = 1;
        this.board = board;
    }

    public boolean solve(){
        if(backtrack(0,0, sol)){
            return true;
        }
        return false;
    }

    public boolean backtrack(int row, int col, int[][] sol){

        if(row == board.length-1 && col == board.length-1){
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            if(i == 0){
                if(check(row, col+1)){
                    sol[row][col+1] = 1;
                    printboard();
                    if(backtrack(row, col+1, sol)){
                        return true;
                    }
                    sol[row][col+1] = 0;
                }
            }
            if(i == 1){
                if(check(row+1, col)){
                    sol[row+1][col] = 1;
                    printboard();
                    if(backtrack(row+1, col, sol)){
                        return true;
                    }
                    sol[row+1][col] = 0;
                }
            }
            if(i == 2){
                if(check(row, col-1)){
                    sol[row][col-1] = 1;
                    printboard();
                    if(backtrack(row, col-1, sol)){
                        return true;
                    }
                    sol[row][col-1] = 0;
                }
            }
            if(i == 3){
                if(check(row-1, col)){
                    sol[row-1][col] = 1;
                    printboard();
                    if(backtrack(row-1, col, sol)){
                        return true;
                    }
                    sol[row-1][col] = 0;
                }
            }
        }

        return false;
    }

    public boolean check(int row, int col){
        if(row < 0){
            return false;
        }

        if(col < 0){
            return false;
        }

        if(row >= board.length){
            return false;
        }

        if(col >= board.length){
            return false;
        }

        if (board[row][col] == 0 && sol[row][col] != 1){
            return true;
        }

        return false;
    }

    public void printboard(){
        System.out.println("-----------");
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
            
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(sol[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    };

}
