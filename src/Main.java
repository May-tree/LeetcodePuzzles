import java.util.*;
public class Main{
    public static void parse(String s){
        boolean zero=false;
        boolean k=false;
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(zero&&k){
                if(isValid(c)){
                    sb.append(c);
                }else{
                    if(sb.length()>0){
                        System.out.println("0k"+revise(sb.toString()));
                        sb=new StringBuilder();
                        zero=false;
                        k=false;
                    }
                }
            }else if(zero){
                if(c=='k'){
                    k=true;
                }else{
                    zero=false;
                }
            }else{
                if(c=='0'){
                    zero=true;
                }
            }
            i++;
        }
        if(zero&&k){
            if(sb.length()>0){
                System.out.println("0k"+revise(sb.toString()));
                sb=new StringBuilder();
                zero=false;
                k=false;
            }
        }


    }
    public static String revise(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        boolean started=false;
        while(i<s.length()){
            char c=s.charAt(i);
            if(started){
                sb.append(c);
            }else{
                if(c!='0'){
                    sb.append(c);
                    started=true;
                }else if(i==s.length()-1){
                    return "0";
                }
            }
            i++;
        }
        return sb.toString();
    }
    public static boolean isValid(char c){
        return (c>='0' && c<='9') ||(c>='A'&& c<= 'E');
    }
    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        String s;
//        while((s=sc.nextLine())!=null){
//            parse(s);
//        }
        String s="0k001";
        parse(s);
    }
}