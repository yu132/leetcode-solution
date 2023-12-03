package redo.p2700_2799;

import java.util.*;

public class P2766 {


    class Solution {
        public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
            DiscretizationHelper discretizationHelper = new DiscretizationHelper(nums);
            for (int loc : moveTo) {
                discretizationHelper.put(loc);
            }
            int[] counter = new int[discretizationHelper.n()];
            for (int num : nums) {
                ++counter[discretizationHelper.get(num)];
            }
            for (int i = 0; i < moveFrom.length; ++i) {
                if (discretizationHelper.get(moveTo[i]) == discretizationHelper.get(moveFrom[i])) {
                    continue;
                }
                counter[discretizationHelper.get(moveTo[i])] += counter[discretizationHelper.get(moveFrom[i])];
                counter[discretizationHelper.get(moveFrom[i])] = 0;
            }
            List<Integer> keys = new ArrayList<>(discretizationHelper.map.keySet());
            Collections.sort(keys);

            List<Integer> ans = new ArrayList<>();

            for (int key : keys) {
                if (counter[discretizationHelper.get(key)] != 0) {
                    ans.add(key);
                }
            }

            return ans;
        }

        class DiscretizationHelper {

            Map<Integer, Integer> map = new HashMap<>();

            public DiscretizationHelper(int[] arr) {
                Arrays.sort(arr);
                for (int num : arr) {
                    put(num);
                }
            }

            public DiscretizationHelper(List<Integer> list) {
                Collections.sort(list);
                for (int num : list) {
                    put(num);
                }
            }

            public void put(int num) {
                if (map.containsKey(num)) {
                    return;
                }
                map.put(num, map.size());
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
