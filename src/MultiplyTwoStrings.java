/**
 * Created by NicolasTsui on 7/16/15.
 */
import java.util.*;
public class MultiplyTwoStrings {
    public static String multiply(String num1, String num2){
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        List<String> list=new ArrayList<>();
        for(int i=num2.length()-1;i>=0;i--){
            int digit2=num2.charAt(i)-'0';
            int extra=0;
            StringBuilder sb=new StringBuilder();
            for(int j=num1.length()-1;j>=0;j--){
                int digit1=num1.charAt(j)-'0';
                int mpln=digit1*digit2;
                int out=(mpln+extra)%10;
                extra=(mpln+extra)/10;
                sb.append(out);
            }
            if(extra>0){
                sb.append(extra);
            }
            sb.reverse();
            list.add(sb.toString());
        }
        String res=list.get(0);
        for(int i=1;i<list.size();i++){
            String adder=addZero(list.get(i), i);
            res=add(res,adder);
        }

        return res;
    }
    public static String addZero(String s,int num){
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        for(int i=0;i<num;i++){
            sb.append("0");
        }
        return sb.toString();
    }
    public static String add(String s1, String s2){
        int i=s1.length()-1;
        int j=s2.length()-1;
        int extra=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 && j>=0){
            int addition=s1.charAt(i--)-'0'+(s2.charAt(j--)-'0');
            sb.append((addition+extra)%10);
            extra=(addition+extra)/10;
        }
        while(i>=0){
            int digit=s1.charAt(i--)-'0';
            sb.append((digit+extra)%10);
            extra=(digit+extra)/10;
        }
        while(j>=0){
            int digit=s2.charAt(j--)-'0';
            sb.append((digit+extra)%10);
            extra=(digit+extra)/10;
        }
        if(extra>0){
            sb.append(extra);
        }
        sb.reverse();
        return sb.toString();

    }
    public static void main(String[] args){
        System.out.println(multiply("12345","65"));
    }
}
