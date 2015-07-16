/**
 * Created by NicolasTsui on 7/16/15.
 * two traverse, find left side max and right size max for each point
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int[] l=new int[A.length];
        int[] r=new int[A.length];
        l[0]=0;
        r[A.length-1]=0;
        int vol=0;
        for(int i=1;i<A.length;i++){
            l[i]=Math.max(l[i-1],A[i-1]);
        }
        for(int i=A.length-2;i>=0;i++){
            r[i]=Math.max(r[i+1],A[i+1]);
        }
        for(int i=0;i<A.length;i++){
            int min=Math.min(l[i],r[i]);
            if(min>A[i]){
                vol+=min-A[i];
            }
        }
        return vol;
    }
}
