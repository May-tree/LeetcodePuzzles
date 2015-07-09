/**
 * Created by NicolasTsui on 7/9/15.
 */
import java.util.*;
public class LetterCombination {
    public List<String> letterCombinations(String digits){
        if(digits.length()==0){
            return new ArrayList<>();
        }
        List<String> result=new ArrayList<>();
        String[] maps={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb=new StringBuilder();
        DFS(result,maps,digits,sb,0);
        return result;
    }
    public void DFS(List<String> result,String[] maps,String digits,StringBuilder sb,int idx){
        if(idx==digits.length()){
            result.add(sb.toString());
            return;
        }
        else{
            int digit=digits.charAt(idx)-'0';
            String str=maps[digit];
            for(int i=0;i<str.length();i++){
                sb.append(str.charAt(i));
                DFS(result,maps,digits,sb,idx+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
