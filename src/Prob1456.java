import java.util.HashMap;
import java.util.Map;

public class Prob1456 {
//
//    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
//    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//    Example 1:
//
//    Input: s = "abciiidef", k = 3
//    Output: 3
//    Explanation: The substring "iii" contains 3 vowel letters.
//    Example 2:
//
//    Input: s = "aeiou", k = 2
//    Output: 2
//    Explanation: Any substring of length 2 contains 2 vowels.
//            Example 3:
//
//    Input: s = "leetcode", k = 3
//    Output: 2
//    Explanation: "lee", "eet" and "ode" contain 2 vowels.
//
//            Constraints:
//
//            1 <= s.length <= 105
//    s consists of lowercase English letters.
//            1 <= k <= s.length
    private static final Map<Character, Boolean> vowelMap = new HashMap<>();
    static {
        vowelMap.put('a', true);
        vowelMap.put('e', true);
        vowelMap.put('i', true);
        vowelMap.put('o', true);
        vowelMap.put('u', true);
    }

    public int maxVowels(String s, int k) {
        int res = 0, currRes = 0;
        for (var i = 0; i < k; i++) {
            if (vowelMap.containsKey(s.charAt(i))){
                currRes++;
            }
        }
        res = currRes;
        for (var i = k; i < s.length(); i++) {
            if (vowelMap.containsKey(s.charAt(i - k))) {
                currRes--;
            }
            if (vowelMap.containsKey(s.charAt(i))) {
                currRes++;
            }
            res = Math.max(currRes, res);
        }
        return res;
    }
}
