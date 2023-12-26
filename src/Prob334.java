public class Prob334 {

    public boolean increasingTriplet(int[] nums) {

        int l = Integer.MAX_VALUE, m = Integer.MAX_VALUE;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] > m) {
                System.out.println(String.format("[%d, %d, %d]", l, m, nums[i]));
                return true;
            }
            else if (nums[i] > l && nums[i] < m) {
                System.out.println(String.format("update mid: %d", nums[i]));
                m = nums[i];
            }
            else if (nums[i] < l) {
                System.out.println(String.format("update left: %d", nums[i]));
                l = nums[i];
            }
        }
        return false;
    }
}
