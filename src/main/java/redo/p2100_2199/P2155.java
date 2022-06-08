package redo.p2100_2199;

import java.util.ArrayList;
import java.util.List;

public class P2155 {

    class Solution {
        public List<Integer> maxScoreIndices(int[] nums) {
            int num1Total = 0;
            for (int num : nums) {
                if (num == 1) {
                    ++num1Total;
                }
            }
            int maxPoint = 0, num0Left = 0;
            List<Integer> maxIndex = new ArrayList<>();
            for (int i = 0; i <= nums.length; ++i) {
                int num1Right = num1Total - (i - num0Left);
                int point = num0Left + num1Right;
                if (point > maxPoint) {
                    maxPoint = point;
                    maxIndex.clear();
                    maxIndex.add(i);
                } else if (point == maxPoint) {
                    maxIndex.add(i);
                }
                if (i != nums.length && nums[i] == 0) {
                    ++num0Left;
                }
            }
            return maxIndex;
        }
    }

}
