import java.util.*;

public class Main{
    public static void solve(String[] s,int start,int end){
        StringBuilder sb=new StringBuilder();
        for(int i=start-1;i<=end-1;i++){
            sb.append(s[i]);
        }
        HashSet<String> pals=solve(sb.toString());
        int res=0;
        for(String pal:pals){
            res+=value(pal);
        }
        System.out.println(res);
    }
    public static int value(String s){
        int res=0;
        for(int i=0;i<s.length();i++){
            res+=s.charAt(i)-'0';
        }
        return res;
    }
    public static HashSet<String> solve(String str){
        System.out.println(str);
        int length= str.length();
        boolean isPalindrome[][]= new boolean[length][length];
        for(int i= 0; i< length; i++){
            for(int j= 0; j <=i; j++){
                isPalindrome[i][j] = true;
            }
        }


        for(int i= length-1; i>=0; i--){
            for(int j= length-1; j>i; j--){
                isPalindrome[i][j] = (str.charAt(i) == str.charAt(j))?isPalindrome[i + 1][j - 1]:false;
            }
        }

        HashSet <String> s = new HashSet();

        for(int i= 0; i< length; i++){
            s.add(str.substring(i,i+1));
        }

        for(int i= 0; i< length; i++){
            for(int j= i; j< length; j++){
                if(isPalindrome[i][j])
                    s.add(str.substring(i,j+1));
            }
        }
        return s;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int visit=sc.nextInt();
        String[] nums=new String[num];
        for(int i=0;i<num;i++){
            nums[i]=sc.next();
        }
        for(int i=0;i<visit;i++){
            solve(nums,sc.nextInt(),sc.nextInt());
        }
    }
}