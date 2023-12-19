public class Prob643 {
//
//    You are given an integer array nums consisting of n elements, and an integer k.
//
//    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
//
//      Example 1:
//
//    Input: nums = [1,12,-5,-6,50,3], k = 4
//    Output: 12.75000
//    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
//    Example 2:
//
//    Input: nums = [5], k = 1
//    Output: 5.00000


    public double findMaxAverage(int[] nums, int k) {
        double res= Integer.MIN_VALUE * 1.0;
        int s = 0;
        for (var i = 0; i < nums.length; ) {
            if (i < k) {
                s += nums[i];
                i++;
                res = (double) s / k;
            } else {
                s -= nums[i - k];
                s += nums[i++];
                res = Math.max(res, (double) s / k);
            }
        }
        return res;
    }

}
