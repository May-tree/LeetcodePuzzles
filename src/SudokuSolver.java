/**
 * Created by NicolasTsui on 7/14/15.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] block=new boolean[9][9];
        boolean found=false;
        int fRow=9;
        int fCol=9;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];
                if(c!='.'){
                    row[i][c-'1']=col[j][c-'1']=block[i / 3 * 3 + j / 3][c-'1']=true;
                }else{
                    if(!found){
                        found=true;
                        fRow=i;
                        fCol=j;
                    }
                }
            }
        }
        if(board == null || board.length == 0)
            return;

        solve(board,row,col,block,fRow,fCol);
    }

    public boolean solve(char[][] board,boolean[][] row,boolean[][] col,boolean[][] block,int i, int j){
        if(i==-1){
            return true;
        }
        for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9 for each cell
            if(isValid(board, i, j, c, row, col, block)){
                board[i][j] = c; //Put c for this cell
                row[i][c-'1']=col[j][c-'1']=block[i / 3 * 3 + j / 3][c-'1']=true;
                int[] nextPos=nextIndex(board,i,j);
                if(solve(board,row,col,block,nextPos[0],nextPos[1]))
                    return true; //If it's the solution return true
                else
                    board[i][j] = '.'; //Otherwise go back
                row[i][c-'1']=col[j][c-'1']=block[i / 3 * 3 + j / 3][c-'1']=false;
            }
        }
        return false;
    }
    public int[] nextIndex(char[][] board,int row,int col){
        int[] next=new int[2];
        next[0]=-1;
        next[1]=-1;
        for(int j=col+1;j<9;j++){
            if(board[row][j]=='.'){
                next[0]=row;
                next[1]=j;
                return next;
            }
        }
        for(int i=row+1;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    next[0]=i;
                    next[1]=j;
                    return next;
                }
            }
        }
        return next;
    }
    public boolean isValid(char[][] board, int i, int j, char c, boolean[][] row,boolean[][] col,boolean[][] block){
        int digit=c-'1';
        return !(row[i][digit] || col[j][digit]||block[i / 3 * 3 + j / 3][digit]);
    }
}
