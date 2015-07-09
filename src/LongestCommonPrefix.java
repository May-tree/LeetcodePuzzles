/**
 * Created by NicolasTsui on 7/9/15.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs[0].length()==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int pos=0;
        char c;
        while(pos<strs[0].length()){
            c=strs[0].charAt(pos);
            for(int i=1;i<strs.length;i++){
                if(pos>=strs[i].length()||strs[i].charAt(pos)!=c){
                    return strs[0].substring(0,pos);
                }
            }
            pos++;
        }
        return strs[0].substring(0,pos);
    }
}
