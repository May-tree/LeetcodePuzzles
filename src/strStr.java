/**
 * Created by NicolasTsui on 7/10/15.
 */
import aces.Kmp_findSubString;
public class StrStr {

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        if(haystack.equals("")){
            return -1;
        }
        return Kmp_findSubString.match(haystack,needle);
    }
}
