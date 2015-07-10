/**
 * Created by NicolasTsui on 7/10/15.
 */
public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        if(A.length==0){
            return 0;
        }
        int i=-1;
        for(int j=0;j<A.length;j++){
            if(A[j]!=elem){
                i++;
                A[i]=A[j];
            }
        }
        return i+1;
    }
}
