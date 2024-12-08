package redo.p3000_3099;

public class P3024 {

    class Solution {
        public String triangleType(int[] nums) {
            int a = nums[0], b = nums[1], c = nums[2];
            if (a + b <= c || a + c <= b || b + c <= a) {
                return "none";
            } else if (a == b && b == c) {
                return "equilateral";
            } else if (a == b || a == c || b == c) {
                return "isosceles";
            } else {
                return "scalene";
            }
        }
    }

}
