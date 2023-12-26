import java.util.Arrays;

public class Prob238 {

    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (var i = 0; i < nums.length; i++) {
            res[i] *= prod;
            prod *= nums[i];
        }

        prod = 1;

        for (var i = nums.length - 1; i >= 0; i--) {
            res[i] *= prod;
            prod *= nums[i];
        }
        return res;
    }
}
