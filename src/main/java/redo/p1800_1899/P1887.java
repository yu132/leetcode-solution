package redo.p1800_1899;

import java.util.*;

public class P1887 {

    class Solution {
        public int reductionOperations(int[] nums) {
            DiscretizationHelper helper = new DiscretizationHelper(nums);
            int ans = 0;
            for (int num : nums) {
                ans += helper.get(num);
            }
            return ans;
        }

        //离散压缩，即将稀疏的数字序列压缩为紧凑的数字序列，不重复,离散值从0开始编号，每次+1
        class DiscretizationHelper {

            Map<Integer, Integer> map = new HashMap<>();

            public DiscretizationHelper(int[] arr) {
                Arrays.sort(arr);
                for (int num : arr) {
                    if (map.containsKey(num)) {
                        continue;
                    }
                    map.put(num, map.size());
                }
            }

            public DiscretizationHelper(List<Integer> list) {
                Collections.sort(list);
                for (int num : list) {
                    if (map.containsKey(num)) {
                        continue;
                    }
                    map.put(num, map.size());
                }
            }

            public int get(int num) {
                return map.getOrDefault(num, -1);
            }

            //离散化后的长度
            public int n() {
                return map.size();
            }
        }
    }

}
