package redo.p1700_1799;

public class P1769 {

    class Solution {
        public int[] minOperations(String boxes) {
            int cl = 0, movel = 0, cr = 0, mover = 0;
            for (int i = 1; i < boxes.length(); ++i) {
                if (boxes.charAt(i) == '1') {
                    ++cr;
                    mover += i;
                }
            }
            int[] ans = new int[boxes.length()];
            for (int i = 0; i < boxes.length() - 1; ++i) {
                ans[i] = movel + mover;
                if (boxes.charAt(i) == '1') {
                    ++cl;
                }
                movel += cl;
                mover -= cr;
                if (boxes.charAt(i + 1) == '1') {
                    --cr;
                }
            }
            ans[boxes.length() - 1] = movel + mover;
            return ans;
        }
    }

}
