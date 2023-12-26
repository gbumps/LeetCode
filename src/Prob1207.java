import java.util.HashMap;

public class Prob1207 {
// 	Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

// Example 1:

// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
// Example 2:

// Input: arr = [1,2]
// Output: false
// Example 3:

// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
 

// Constraints:

// 1 <= arr.length <= 1000
// -1000 <= arr[i] <= 1000

	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> res = new HashMap<>();
		for (var i = 0; i < arr.length;i++) {
			if (res.containsKey(arr[i])) {
				res.put(arr[i], res.get(arr[i]) + 1);
			} else {
				res.put(arr[i], 1);
			}
		}

		Integer[] v = res.values().toArray(new Integer[0]);
		for (var i = 0; i < v.length; i++) {
			for (var j = 0; j < v.length; j++) {
				if (i != j && v[i] == v[j]) {
					return false;
				}
			}
		}
		return true;
    }
}