/**
 * Created by NicolasTsui on 7/9/15.
 */
public class IsPalindrome {
    public static boolean isPld(int x) {
        if(x<0){
            return false;
        }
        int y=reverse(x);
        return x==y;
    }
    public static int reverse(int x){
        long result=0;
        while(x!=0){
            result=result*10+x%10;
            x/=10;
        }
        return (result>Integer.MAX_VALUE ||result<Integer.MIN_VALUE)?0:(int)result;
    }
}
