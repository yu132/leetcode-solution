package redo.p0600_0699;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class P632 {

    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            TreeSet<Node> treeSet = new TreeSet<>(Comparator.<Node>comparingInt(x -> x.num)
                    .thenComparing(x -> x.index));

            int n = nums.size();

            int[] idxs = new int[n];

            Arrays.fill(idxs, 1);

            for (int i = 0; i < n; ++i) {
                treeSet.add(new Node(i, nums.get(i).get(0)));
            }

            int[] ans = new int[]{treeSet.first().num, treeSet.last().num};
            while (true) {
                int idxMin = treeSet.first().index;
                if (idxs[idxMin] == nums.get(idxMin).size()) {
                    break;
                }
                treeSet.pollFirst();
                treeSet.add(new Node(idxMin, nums.get(idxMin).get(idxs[idxMin]++)));
                if (treeSet.last().num - treeSet.first().num < ans[1] - ans[0]) {
                    ans = new int[]{treeSet.first().num, treeSet.last().num};
                }
            }
            return ans;
        }

        class Node {
            int num;
            int index;

            public Node(int index, int num) {
                this.num = num;
                this.index = index;
            }
        }
    }

}
