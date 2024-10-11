
public class QuestionRecursion {
    public static void main(String[] args) {
        int n =6;

        boolean[][] board=new boolean[n][n];
        System.out.println(NQueens(board,0));

    }

    static int NQueens(boolean[][] board,int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        // placing the queen and checking the diagonals and clmbs/raw
        for (int col = 0; col < board.length; col++) {
            //place the queen if it is safe
            if (isSafe(board, row, col)){
                board[row][col] = true;
                count += NQueens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board,int row, int col){
        //check the vertical row
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        //check the left diagonal
        int maxLeft=Math.min(col,row);
        for (int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        //check the right diagonal
        int maxRight=Math.min(board.length-col-1,row);
        for (int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;

    }

    private static void display(boolean[][] board){
        for (boolean[] row:board){
            for (boolean cell:row){

                if (cell){
                    System.out.print("Q ");
                }
                else {
                    System.out.print("x ");
                }

            }
            System.out.println();
        }
    }

}
