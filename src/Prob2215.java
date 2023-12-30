import java.util.*;
import java.util.HashMap;

public class Prob2215 {

//    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
//
//    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
//            answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
//    Note that the integers in the lists may be returned in any order.
//
//    Example 1:
//
//    Input: nums1 = [1,2,3], nums2 = [2,4,6]
//    Output: [[1,3],[4,6]]
//    Explanation:
//    For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
//    For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
//    Example 2:
//
//    Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
//    Output: [[3],[]]
//    Explanation:
//    For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
//    Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, Boolean> map1 = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int max = Math.max(nums1.length, nums2.length), i = 0;
        while (i < max) {
            if (i < nums1.length) {
                map.put(nums1[i], true);
                map1.put(nums1[i], true);
            }
            if (i < nums2.length) {
                map.put(nums2[i], true);
                map1.put(nums2[i], true);
            }
            i++;
        }
        i = 0;
        while (i < max) {
            if (i < nums1.length && map.containsKey(nums1[i])) {
                map.remove(nums1[i]);
            }
            if (i < nums2.length && map1.containsKey(nums2[i])) {
                map1.remove(nums2[i]);
            }
            i++;
        }

        res.add(map1.keySet().stream().toList());
        res.add(map.keySet().stream().toList());
        return res;
    }
}
