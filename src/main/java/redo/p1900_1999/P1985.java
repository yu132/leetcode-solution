package redo.p1900_1999;

import java.util.Arrays;

public class P1985 {

    class Solution {

        public String kthLargestNumber(String[] nums, int k) {
            Arrays.sort(nums, this::intCompare);
            return nums[nums.length - k];
        }

        int intCompare(String a, String b) {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            for (int i = 0; i < a.length(); ++i) {
                if (a.charAt(i) != b.charAt(i)) {
                    return Integer.compare(a.charAt(i), b.charAt(i));
                }
            }
            return 0;
        }


    }

}
