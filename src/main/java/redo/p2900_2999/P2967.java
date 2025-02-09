package redo.p2900_2999;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2967 {

    class Solution {
        public long minimumCost(int[] nums) {
            Arrays.sort(nums);
            long avg;
            if (nums.length % 2 == 0) {
                avg = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
            } else {
                avg = nums[nums.length / 2];
            }
            Integer[] digit = toDigits(avg);
            for (int i = 0; i < digit.length / 2; ++i) {
                digit[digit.length - i - 1] = digit[i];
            }
            long choose1 = fromDigits(digit);
            long temp1 = avg + (long) Math.pow(10, digit.length / 2);
            Integer[] digit2 = toDigits(temp1);
            for (int i = 0; i < digit2.length / 2; ++i) {
                digit2[digit2.length - i - 1] = digit2[i];
            }
            long choose2 = fromDigits(digit2);
            long temp2 = avg - (long) Math.pow(10, digit.length / 2);
            Integer[] digit3 = toDigits(temp2);
            if (digit3.length < digit.length) {
                for (int i = 0; i < digit3.length; ++i) {
                    digit3[i] = 9;
                }
            } else {
                for (int i = 0; i < digit3.length / 2; ++i) {
                    digit3[digit3.length - i - 1] = digit3[i];
                }
            }
            long choose3 = fromDigits(digit3);
            long ans1 = 0;
            long ans2 = 0;
            long ans3 = 0;
            for (int num : nums) {
                ans1 += Math.abs(num - choose1);
                ans2 += Math.abs(num - choose2);
                ans3 += Math.abs(num - choose3);
            }
            return Math.min(Math.min(ans1, ans2), ans3);
        }

        Integer[] toDigits(long num) {
            List<Integer> list = new ArrayList<>();
            while (num != 0) {
                list.add((int) (num % 10));
                num /= 10;
            }
            Collections.reverse(list);
            if (list.isEmpty()) {
                list.add(0);
            }
            return list.toArray(new Integer[0]);
        }

        long fromDigits(Integer[] digits) {
            long num = 0;
            for (int i = 0; i < digits.length; ++i) {
                num = num * 10 + digits[i];
            }
            return num;
        }
    }

    public static void main(String[] args) {
        new P2967().new Solution().minimumCost(Arrs.build("[900,1000,1000]"));
//        int[] arr = Arrs.build("[123,765,1567]");
//        for (int i = 0; i < 2000; ++i) {
//            if (isPalindrome(i)) {
//                long sum = 0;
//                for (int num : arr) {
//                    sum += Math.abs(i - num);
//                }
//                System.out.println(i + " " + sum);
//            }
//        }
    }

    public static boolean isPalindrome(int num) {
        return reverse(num) == num;
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

}
