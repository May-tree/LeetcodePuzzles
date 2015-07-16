/**
 * Created by NicolasTsui on 7/16/15.
 */
public class JumpGame {
    public boolean canJump(int[] A){
        int max=0;
        for(int i=0;i<A.length;i++){
            if(max>=i){
                max=Math.max(i,A[i]+i);
            }
        }
        return max>=A.length;
    }
}
