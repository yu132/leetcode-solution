package redo.p2800_2899;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P2831 {

    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int ans = 1;
            Map<Integer, LinkedList<Integer>> listMap = new HashMap<>();
            for (int i = 0; i < nums.size(); ++i) {
                int num = nums.get(i);
                if (!listMap.containsKey(num)) {
                    listMap.put(num, new LinkedList<>());
                }
                LinkedList<Integer> list = listMap.get(num);
                list.addLast(i);
                while (i + 1 - list.peekFirst() - list.size() > k) {
                    list.removeFirst();
                }
                ans = Math.max(ans, list.size());
            }
            return ans;
        }
    }

}
