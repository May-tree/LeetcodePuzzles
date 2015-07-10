/**
 * Created by NicolasTsui on 7/11/15.
 */
public class MininumWindowSubString {
    public static String minWindow(String s, String t) {
        int[] tmap=new int[256];
        int[] smap=new int[256];
        for(int k=0;k<t.length();k++){
            tmap[t.charAt(k)]++;
        }
        int found=0;
        int i=0,j=0;
        int minLen=Integer.MAX_VALUE;
        String result="";
        while(j<s.length()){
            char tail=s.charAt(j);
            if(found<t.length()){
                if(tmap[tail]>0) {
                    smap[tail]++;
                    if (smap[tail] <= tmap[tail]) {
                        found++;
                    }
                }
            }
            while(found==t.length()){
                char head=s.charAt(i);
                if(j-i+1<minLen){
                    minLen=j-i+1;
                    result=s.substring(i,j+1);
                }
                if(tmap[head]>0){
                    smap[head]--;
                    if(smap[head]<tmap[head]){
                        found--;
                    }
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
