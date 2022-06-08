package redo.Util.ag.countReverse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryIndexTree {

    static//

    class Solution {
        public int reversePairs(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int type = discretizationInSameIndex(nums);

            BIT bit = new BIT(type);

            int ans = 0;

            for (int i = 0; i < nums.length; ++i) {
                ans += i - bit.get(nums[i] + 1);
                bit.add(nums[i], 1);
            }

            return ans;
        }

        // 返回离散化后的种数
        int discretizationInSameIndex(int[] val) {
            int[] copy = Arrays.copyOf(val, val.length);
            Arrays.sort(copy);
            Map<Integer, Integer> map = new HashMap<>(val.length * 2);
            map.put(copy[0], 0);
            for (int i = 1; i < val.length; ++i) {
                if (copy[i] != copy[i - 1]) {
                    map.put(copy[i], map.size());
                }
            }
            for (int i = 0; i < val.length; ++i) {
                val[i] = map.get(val[i]);
            }
            return map.size();
        }

        static class BIT {
            int[] c;

            public BIT(int len) {
                this.c = new int[len + 1];
            }

            void add(int index, int val) {
                for (int i = index + 1; i < c.length; i += i & -i) {
                    c[i] += val;
                }
            }

            // exclude index
            int get(int index) {
                int sum = 0;
                for (int i = index; i > 0; i -= i & -i) {
                    sum += c[i];
                }
                return sum;
            }
        }
    }

}
