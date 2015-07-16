/**
 * Created by NicolasTsui on 7/16/15.
 */
public class JumpGameII {
    public static int jump(int[] A) {
        if(A.length<=1){
            return 0;
        }
        int step=1;
        int start=0;
        int edge=A[0];
        while(edge<A.length-1){
            int tempEdge=edge;
            for(int i=start;i<=edge;i++){
                tempEdge=Math.max(tempEdge,i+A[i]);
            }
            start=edge+1;
            edge=tempEdge;
            step++;
        }
        return step;
    }
    public static void main(String[] args){
        int[] a={1,1,1,1};
        System.out.println(jump(a));
    }
}
