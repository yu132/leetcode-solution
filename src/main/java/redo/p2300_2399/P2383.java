package redo.p2300_2399;

import redo.testUtil.Arrs;

public class P2383 {

    class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

            int sum = sum(energy);

            int diff = 0;
            for (int j : experience) {
                if (initialExperience <= j) {
                    int temp = j + 1 - initialExperience;
                    diff += temp;
                    initialExperience += temp + j;
                } else {
                    initialExperience += j;
                }
            }

            return diff + (initialEnergy > sum ? 0 : sum + 1 - initialEnergy);
        }

        int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        new P2383().new Solution().minNumberOfHours(5, 3, Arrs.build("[1,4,3,2]"), Arrs.build("[2,6,3,1]"));
    }

}
