/**
 * Created by NicolasTsui on 7/14/15.
 */
public class CountAndSay {
    public static String countAndSay(int n){
        String res="1";
        for(int i=1;i<n;i++){
            res=say(res);
        }
        return res;
    }
    public static String say(String res){
        StringBuilder sb=new StringBuilder();
        if(res.length()==0){
            return "";
        }
        int i=1,count=1;
        int digit=res.charAt(0)-'0';
        while(i<res.length()){
            int tempDigit=res.charAt(i)-'0';
            if(tempDigit==digit){
                count++;
                i++;
            }else{
                sb.append(count);
                sb.append(digit);
                sb.append(say(res.substring(i)));
                return sb.toString();
            }
        }
        sb.append(count);
        sb.append(digit);
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }
}
