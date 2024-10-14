public class SudokuSolver{
    public static void main(String[] args) {
        int[][] sudoku = {
                {0, 0, 0, 0, 0, 0, 5, 0, 0},
                {0, 0, 6, 0, 0, 8, 0, 4, 3},
                {0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 5, 0, 0, 8, 0},
                {0, 0, 0, 6, 0, 4, 0, 0, 0},
                {0, 1, 0, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 0},
                {3, 7, 0, 4, 0, 0, 6, 0, 0},
                {0, 0, 4, 0, 0, 0, 0, 0, 0}
        };

        if (solve(sudoku)) {
            display(sudoku);
        } else {
            System.out.println("No solution exists."); // Added: Handle unsolvable puzzles
        }
    }

    static boolean solve(int[][] board){
        int row=-1;
        int col=-1;
        int n=board.length;
        boolean empty=false;

        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(board[i][j]==0) {
                    row = i;
                    col = j;
                    empty = true;
                    break;
                }
            }

            if(empty) break;
        }


        //sudoku solved
        if(!empty) return true;

        for(int num=1;num<=9;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solve(board)){
                    return true;
                }
                else board[row][col]=0;
            }
        }

        return false;
    }

    static void display(int[][] board){
        for (int[] arr:board){
            for (int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }


    static boolean isSafe(int[][] board,int row,int col,int num){
        //check the row
        for (int i=0;i<board.length;i++){
            //check if the number is in the row
            if(board[i][col]==num) return false;
            if(board[row][i]==num) return false;
        }

        int sqrt=(int)Math.sqrt(board.length);
        int starterRow=row-row%sqrt;
        int starterCol=col-col%sqrt;

        for (int r=starterRow;r<=starterRow+2;r++){
            for (int c=starterCol;c<starterCol+2;c++){
                if (board[r][c]==num) return false;
            }
        }

        return true;

    }


}
