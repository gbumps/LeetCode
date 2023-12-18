import java.util.ArrayList;
import java.util.List;

public class Prob1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = maxInList(candies);
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(
                    candy + extraCandies >= maxValue
            );
        }
        return res;
    }

    private int maxInList(int[] m) {
        int max = Integer.MIN_VALUE;
        for (int j : m) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
