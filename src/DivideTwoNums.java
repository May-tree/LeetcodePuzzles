/**
 * Created by NicolasTsui on 7/10/15.
 */
public class DivideTwoNums {
    public static int divide(int dividend, int divisor){
        long dnd=dividend;
        long dsr=divisor;
        if(Math.abs(dnd)<Math.abs(dsr)){
            return 0;
        }
        if(dsr==0){
            return Integer.MAX_VALUE;
        }
        boolean dndN=false;
        boolean dsrN=false;
        if(dnd<0){
            dndN=true;
            dnd=-dnd;
        }
        if(dsr<0){
            dsrN=true;
            dsr=-dsr;
        }
        long result=0;
        long remain=dnd;
        while(remain>=dsr){
            int shift=shift(remain,dsr);
            if(shift==0){
                result+=1;
                remain-=dsr;
            }
            else {
                result += 2 << (shift - 1);
                remain-=dsr<<shift;
            }

        }
        if((dndN && dsrN)||(!dndN && !dsrN)){
            return (int)result;
        }
        else{
            return -(int)result;
        }
    }
    public static int shift(long a,long b){
        long dsr=b;
        int shift=0;
        while(dsr<<1<=a){
            dsr=dsr<<1;
            shift++;
        }
        return shift;
    }
    public static void main(String[] args){
        System.out.println(Integer.MIN_VALUE/-1);
//        System.out.println(divide(Integer.MIN_VALUE,0));
    }
}
