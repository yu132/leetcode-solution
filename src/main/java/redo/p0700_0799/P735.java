package redo.p0700_0799;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P735 {

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            LinkedList<Integer> stack = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            for (int num : asteroids) {
                if (num < 0) {
                    outer:
                    {
                        while (!stack.isEmpty() && stack.peek() > 0) {
                            if (stack.peek() > -num) {
                                break outer;
                            } else if (stack.peek() < -num) {
                                stack.pop();
                            } else {
                                stack.pop();
                                break outer;
                            }
                        }
                        ans.add(num);
                    }
                } else {
                    stack.push(num);
                }
            }
            while (!stack.isEmpty()) {
                ans.add(stack.removeLast());
            }
            return toIntArray(ans);
        }

        int[] toIntArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        new P735().new Solution().asteroidCollision(new int[]{-2, -2, 1, -2});
    }
}
