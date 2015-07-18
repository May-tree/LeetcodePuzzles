/**
 * Created by NicolasTsui on 7/18/15.
 */
import java.util.*;
public class RomanToInteger {
    public static int romanToInt(String s) {
        int i=0;
        int res=0;
        HashMap<Character,Integer> value=new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X',10);
        value.put('L',50);
        value.put('C',100);
        value.put('D',500);
        value.put('M',1000);
        while(i<s.length()){
            char c=s.charAt(i);
            if(i<s.length()-1){
                char nc=s.charAt(i+1);
                if((c=='I'||c=='C'||c=='X')&&value.get(c)<value.get(nc)){
                    res+=value.get(nc)-value.get(c);
                    i++;
                }else{
                    res+=value.get(c);
                }
            }else{
                res+=value.get(c);
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(romanToInt("MMXIV"));
    }
}
