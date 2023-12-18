import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Prob1071 {
    public String gcdOfStrings(String str1, String str2) {
        int maxLength = Math.min(str1.length(), str2.length());
        String res = "";

        for (int i = 1; i <= maxLength; i++) {
            List<String> s1 = splitString(str1, i);
            List<String> s2 = splitString(str2, i);

            if (isContinuosDuplication(s1, s2) && res.length() < s1.get(0).length()) {
               res = s1.get(0);
            }
        }
        return res;
    }

    private boolean isContinuosDuplication(List<String> s1, List<String> s2) {
        String strToRemove = s1.get(0);
        List<String> a = new ArrayList<>(s1);
        List<String> b = new ArrayList<>(s2);
        a.removeIf(s -> s.equals(strToRemove));
        b.removeIf(s -> s.equals(strToRemove));
        return a.isEmpty() && b.isEmpty();
    }

    private List<String> splitString(String input, int chunkSize) {
        int length = input.length();
        int numOfChunks = (int) Math.ceil((double) length / chunkSize);
        String[] chunks = new String[numOfChunks];

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize, length);
            chunks[i] = input.substring(start, end);
        }

        return Arrays.stream(chunks).toList();
    }
}