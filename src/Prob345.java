import java.util.HashMap;
import java.util.Map;

public class Prob345 {


//    Given a string s, reverse only all the vowels in the string and return it.
//
//    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
//    and upper cases, more than once.
//
//    Example 1:
//    Input: s = "hello"
//    Output: "holle"

//    Example 2:
//    Input: s = "leetcode"
//    Output: "leotcede"


    private static final Map<Character, Boolean> vowelMap = new HashMap<>();
    static {
        vowelMap.put('a', true);
        vowelMap.put('e', true);
        vowelMap.put('i', true);
        vowelMap.put('o', true);
        vowelMap.put('u', true);
        vowelMap.put('A', true);
        vowelMap.put('E', true);
        vowelMap.put('I', true);
        vowelMap.put('O', true);
        vowelMap.put('U', true);
    }

    public String reverseVowels(String s) {
        int l = 0;
        char[] res = s.toCharArray();
        for (var r = s.length() - 1; r >= 0; r--) {
            if (vowelMap.containsKey(res[r])) {
                while (!vowelMap.containsKey(s.charAt(l)) && l < s.length()) {
                    l += 1;
                }
                if (vowelMap.containsKey(s.charAt(l))) {
                    char tmp = res[l];
                    res[l] = res[r];
                    res[r] = tmp;
                    l += 1;
                }
            }
            if (l >= r) break;
        }
        return new String(res);
    }
}
