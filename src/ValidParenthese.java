/**
 * Created by NicolasTsui on 7/9/15.
 */
import java.util.*;
public class ValidParenthese {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        HashMap<Character,Character> parentMap=new HashMap<>();
        parentMap.put(')','(');
        parentMap.put(']','[');
        parentMap.put('}','{');
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(!stack.isEmpty() && parentMap.containsKey(stack.peek())){
                return false;
            }
            else if(!stack.isEmpty() && parentMap.containsKey(c)){
                if(stack.peek()==parentMap.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
