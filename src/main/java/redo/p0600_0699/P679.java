package redo.p0600_0699;

import redo.testUtil.Arrs;

public class P679 {

    class Solution {

        double e = 1e-5;

        public boolean judgePoint24(int[] cards) {
            double[] copy = new double[cards.length];
            for (int i = 0; i < cards.length; ++i) {
                copy[i] = cards[i];
            }
            return backtrack(0, copy);
        }

        public boolean backtrack(int now, double[] nums) {
            if (now == nums.length) {
                return helper(nums);
            }
            for (int i = now; i < nums.length; ++i) {
                double temp = nums[i];
                nums[i] = nums[now];
                nums[now] = temp;
                if (backtrack(now + 1, nums)) {
                    return true;
                }
                nums[now] = nums[i];
                nums[i] = temp;
            }
            return false;
        }

        public boolean helper(double[] cards) {
            if (cards.length == 1) {
                return Math.abs(cards[0] - 24) < e;
            }
            for (int i = 1; i < cards.length; ++i) {
                double[] copy = new double[cards.length - 1];
                System.arraycopy(cards, 0, copy, 0, i - 1);
                if (copy.length - i >= 0) System.arraycopy(cards, i + 1, copy, i, copy.length - i);
                copy[i - 1] = cards[i - 1] + cards[i];
                if (helper(copy)) {
                    return true;
                }
                copy[i - 1] = cards[i - 1] - cards[i];
                if (helper(copy)) {
                    return true;
                }
                copy[i - 1] = cards[i - 1] * cards[i];
                if (helper(copy)) {
                    return true;
                }
                if (cards[i] != 0) {
                    copy[i - 1] = cards[i - 1] / cards[i];
                    if (helper(copy)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        boolean b = new P679().new Solution().judgePoint24(Arrs.build("[3,3,8,8]"));
        System.out.println(b);
    }

}
