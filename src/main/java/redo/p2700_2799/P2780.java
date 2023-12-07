package redo.p2700_2799;

import redo.testUtil.Arrs;

import java.util.List;

public class P2780 {

    class Solution {
        public int minimumIndex(List<Integer> nums) {
            int[] maxCountNum = maxCountNum(nums);
            if (null == maxCountNum) {
                return -1;
            }
            int count = maxCountNum[1];
            int num = maxCountNum[0];
            int left = 0;
            for (int i = 0; i < nums.size() - 1; ++i) {
                if (nums.get(i) == num) {
                    ++left;
                }
                if (left > (i + 1) / 2 && (count - left) > (nums.size() - i - 1) / 2) {
                    return i;
                }
            }
            return -1;
        }

        int[] maxCountNum(List<Integer> list) {
            int num = list.get(0), count = 1;
            for (int i = 1; i < list.size(); ++i) {
                if (num == list.get(i)) {
                    ++count;
                } else {
                    if (count == 0) {
                        num = list.get(i);
                        count = 1;
                    } else {
                        --count;
                    }
                }
            }
            int realCount = getEleCount(list, num);
            if (realCount >= list.size() / 2) {
                return new int[]{num, realCount};
            } else {
                return null;
            }
        }

        int getEleCount(List<Integer> list, int val) {
            int count = 0;
            for (Integer integer : list) {
                if (val == integer) {
                    ++count;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        new P2780().new Solution().minimumIndex(Arrs.buildL("[1,2,2,2]"));
    }

}
