package redo.p2100_2199;

public class P2170 {

    class Solution {
        public int minimumOperations(int[] nums) {
            int[] oddCount = new int[100001];
            int[] evenCount = new int[100001];
            for (int i = 0; i < nums.length; i += 2) {
                ++evenCount[nums[i]];
            }
            for (int i = 1; i < nums.length; i += 2) {
                ++oddCount[nums[i]];
            }
            int maxCountOdd = Integer.MIN_VALUE, maxValueOdd = 0, maxCountOdd2 = Integer.MIN_VALUE, maxValueOdd2 = 0,
                    maxCountEven = Integer.MIN_VALUE, maxValueEven = 0, maxCountEven2 = Integer.MIN_VALUE, maxValueEven2 = 0;
            for (int i = 0; i < oddCount.length; ++i) {
                if (oddCount[i] >= maxCountOdd) {
                    maxCountOdd2 = maxCountOdd;
                    maxValueOdd2 = maxValueOdd;
                    maxCountOdd = oddCount[i];
                    maxValueOdd = i;
                } else if (oddCount[i] >= maxCountOdd2) {
                    maxCountOdd2 = oddCount[i];
                    maxValueOdd2 = i;
                }
            }
            for (int i = 0; i < evenCount.length; ++i) {
                if (evenCount[i] > maxCountEven) {
                    maxValueEven2 = maxValueEven;
                    maxCountEven2 = maxCountEven;
                    maxValueEven = i;
                    maxCountEven = evenCount[i];
                } else if (evenCount[i] > maxCountEven2) {
                    maxValueEven2 = i;
                    maxCountEven2 = evenCount[i];
                }
            }
            int min = Integer.MAX_VALUE;
            if (maxValueOdd != maxValueEven) {
                min = Math.min(min, nums.length - maxCountOdd - maxCountEven);
            }
            if (maxValueOdd != maxValueEven2) {
                min = Math.min(min, nums.length - maxCountOdd - maxCountEven2);
            }
            if (maxValueOdd2 != maxValueEven) {
                min = Math.min(min, nums.length - maxCountOdd2 - maxCountEven);
            }
            if (maxValueOdd2 != maxValueEven2) {
                min = Math.min(min, nums.length - maxCountOdd2 - maxCountEven2);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 4, 3, 4, 3, 3, 5, 3, 5, 3, 3};
        new P2170().new Solution().minimumOperations(arr);
    }

}
