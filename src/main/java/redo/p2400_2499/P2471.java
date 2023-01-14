package redo.p2400_2499;

import model.TreeNode;

import java.util.*;

public class P2471 {

    class Solution {
        public int minimumOperations(TreeNode root) {
            List<List<Integer>> flat = flatByLevel(root);
            int ans = 0;
            for (List<Integer> level : flat) {
                ans += minSwapAny(level);
            }
            return ans;
        }

        int minSwapAny(List<Integer> list) {
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);

            Map<Integer, Integer> indexSorted = new HashMap<>();
            for (int i = 0; i < sorted.size(); ++i) {
                indexSorted.put(sorted.get(i), i);
            }

            int count = 0;
            for (int i = 0; i < list.size(); ++i) {
                int val = list.get(i);
                if (indexSorted.containsKey(val)) {
                    ++count;
                }
                while (indexSorted.containsKey(val)) {
                    val = list.get(indexSorted.remove(val));
                }
            }

            return list.size() - count;
        }

        List<List<Integer>> flatByLevel(TreeNode root) {
            List<List<Integer>> collector = new ArrayList<>();
            dfsHelperFlatByLevel(root, 0, collector);
            return collector;
        }

        void dfsHelperFlatByLevel(TreeNode node, int level, List<List<Integer>> collector) {
            if (null == node) {
                return;
            }
            if (collector.size() == level) {
                collector.add(new ArrayList<>());
            }
            collector.get(level).add(node.val);
            dfsHelperFlatByLevel(node.left, level + 1, collector);
            dfsHelperFlatByLevel(node.right, level + 1, collector);
        }
    }

}
