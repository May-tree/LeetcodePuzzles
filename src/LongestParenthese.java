/**
 * Created by NicolasTsui on 7/13/15.
 */
import java.util.*;
public class LongestParenthese {

    public static class parent{
        char c;
        int n;
        public parent(char c,int n){
            this.c=c;
            this.n=n;
        }
    }
    public static int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0;
        Stack<parent> stack=new Stack<>();
        stack.push(new parent('*',0));
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')' && stack.peek().c=='('){
                int count=stack.peek().n+2;
                stack.pop();
                stack.peek().n+=count;
                max=Math.max(max,stack.peek().n);
            }
            else{
                stack.push(new parent(c,0));
            }
        }
        return max;
    }
}
