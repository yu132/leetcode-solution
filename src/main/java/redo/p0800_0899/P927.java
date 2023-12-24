package redo.p0800_0899;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.List;

public class P927 {

    class Solution {
        public int[] threeEqualParts(int[] arr) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] == 1) {
                    list.add(i);
                }
            }
            if (list.size() % 3 != 0) {
                return new int[]{-1, -1};
            }
            if (list.size() == 0) {
                return new int[]{0, 2};
            }
            int lIdx = list.size() / 3, rIdx = list.size() / 3 * 2;
            int minZ = arr.length - list.get(list.size() - 1) - 1;
            if (list.get(rIdx) - list.get(rIdx - 1) - 1 < minZ
                    || list.get(lIdx) - list.get(lIdx - 1) - 1 < minZ) {
                return new int[]{-1, -1};
            }
            for (int i = 1; i < list.size() / 3; ++i) {
                int diff1 = list.get(i) - list.get(i - 1);
                int diff2 = list.get(i + lIdx) - list.get(i + lIdx - 1);
                int diff3 = list.get(i + rIdx) - list.get(i + rIdx - 1);
                if (diff1 != diff2 || diff1 != diff3) {
                    return new int[]{-1, -1};
                }
            }
            return new int[]{list.get(lIdx - 1) + minZ, list.get(rIdx - 1) + minZ + 1};
        }
    }

    public static void main(String[] args) {
        new P927().new Solution().threeEqualParts(Arrs.build("[1,0,1,0,1]"));
    }

}
