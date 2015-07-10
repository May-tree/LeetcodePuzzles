package knigthMovePuzzle;

import java.util.ArrayList;
import java.util.List;

public class pos{
    int row;
    int col;
    pos parent;
    public pos(int i,int j) {
        row = i;
        col = j;
        parent=null;
    }
    public void print(){
        System.out.println((char)('a'+col)+""+(8-row));
    }
    public boolean isValid(){
        return row>=0 && row<=7 && col>=0&& col<=7;
    }
    public List<pos> nextMoves(){
        int[] dir={1,-1};
        List<pos> moves=new ArrayList<>();
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    int nextRow=row+dir[i]*(2-k);
                    int nextCol=col+dir[j]*(1+k);
                    pos newpos=new pos(nextRow,nextCol);
                    if(newpos.isValid()){
                        moves.add(newpos);
                    }
                }
            }
        }
        return moves;
    }
    public boolean equalTo(pos foo){
        return this.row==foo.row && this.col==foo.col;
    }
    public boolean isVisited(boolean[][] visited){
        return visited[row][col];
    }
}
