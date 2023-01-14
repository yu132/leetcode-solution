package redo.p2400_2499;


import java.util.HashMap;
import java.util.Map;

public class P2453 {

    class Solution {
        public int destroyTargets(int[] nums, int space) {
            Map<Integer, Node> map = new HashMap<>();
            for (int num : nums) {
                Node node = map.computeIfAbsent(num % space, x -> new Node());
                ++node.count;
                node.min = Math.min(node.min, num);
            }
            Node target = new Node();
            for (Node node : map.values()) {
                if (node.count > target.count) {
                    target = node;
                } else if (node.count == target.count && node.min < target.min) {
                    target = node;
                }
            }
            return target.min;
        }

        class Node {
            int count = 0;
            int min = Integer.MAX_VALUE;
        }
    }

}
