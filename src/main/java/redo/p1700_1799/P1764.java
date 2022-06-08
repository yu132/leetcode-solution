package redo.p1700_1799;

public class P1764 {

    class Solution {
        public boolean canChoose(int[][] groups, int[] nums) {
            for (int i = 0, index = 0; i < groups.length; ++i) {
                if ((index = indexOf(nums, groups[i], index)) == -1) {
                    return false;
                }
                index += groups[i].length;
            }
            return true;
        }

        //查找第一个能匹配的子数组的开始下标
        public int indexOf(int[] src, int[] toMatch, int start) {
            outer:
            for (int i = start; i <= src.length - toMatch.length; ++i) {
                for (int j = 0; j < toMatch.length; ++j) {
                    if (src[i + j] != toMatch[j]) {
                        continue outer;
                    }
                }
                return i;
            }
            return -1;
        }
    }

}
