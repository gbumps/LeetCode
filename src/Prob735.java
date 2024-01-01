import java.util.ArrayDeque;

public class Prob735 {
//    We are given an array asteroids of integers representing asteroids in a row.
//
//    For each asteroid, the absolute value represents its size, and the sign represents
//    its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//    Find out the state of the asteroids after all collisions.
//    If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

//    Example 1:
//
//    Input: asteroids = [5,10,-5]
//    Output: [5,10]
//    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//    Example 2:
//
//    Input: asteroids = [8,-8]
//    Output: []
//    Explanation: The 8 and -8 collide exploding each other.
//    Example 3:
//
//    Input: asteroids = [10,2,-5]
//    Output: [10]
//    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
//
//
//    Constraints:
//
//    2 <= asteroids.length <= 104
//    -1000 <= asteroids[i] <= 1000
//    asteroids[i] != 0

    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(asteroids[0]);
        int i = 1;
        while (i < asteroids.length) {
            int r = asteroids[i];
            boolean isNegative = !stack.isEmpty() && stack.getLast() < 0 && r < 0;
            if (isNegative) {
                stack.add(r);
            } else if ((r > 0) || stack.isEmpty()) {
                stack.add(r);
            } else if (r < 0) {
                int l = stack.getLast();
                boolean needToAdd = false;
                while (l > 0) {
                    if (Math.abs(l) >= Math.abs(r)) {
                        needToAdd = false;
                        if (Math.abs(l) == Math.abs(r)) {
                            stack.removeLast();
                        }
                        break;
                    } else {
                        needToAdd = true;
                        stack.removeLast();
                    }
                    if (!stack.isEmpty()) {
                        l = stack.getLast();
                    } else {
                        break;
                    }
                }
                if (needToAdd) {
                    stack.add(r);
                }
            }
            i++;
        }

        int[] res = new int[stack.size()];
        int j = 0;
        for (Integer num: stack) {
            res[j++] = num;
        }
        return res;
    }
}
