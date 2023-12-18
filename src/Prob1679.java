import java.util.Arrays;
import java.util.HashMap;

public class Prob1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, count = 0;
        // HashMap<String, Integer> map = new HashMap<>();
        while (l < r) {
            if (nums[r] <= k) {
                for (var i = l; i < r; i++) {
                    if (nums[i] == k - nums[r]) {
                        // String key = String.format("%d-%d", nums[r], nums[i]);
                        // if (map.containsKey(key)) {
                        //     map.put(key, map.get(key) + 1);
                        // } else {
                        //     map.put(key, 1);
                        // }
                        count++;
                        l = i + 1;
                        break;
                    }
                }
            }
            r--;
        }
        return count;
        // map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
