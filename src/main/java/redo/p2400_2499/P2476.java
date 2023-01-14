package redo.p2400_2499;

import model.TreeNode;
import redo.testUtil.BinaryTreeTestUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class P2476 {

    class Solution {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

            List<Integer> list = new ArrayList<>();
            inorder(root, list::add);

            List<List<Integer>> ans = new ArrayList<>();
            for (int val : queries) {
                ans.add(new ArrayList<Integer>() {{
                    int indexMax = binarySearchMax(0, list.size(), x -> list.get(x) <= val);
                    if (indexMax == -1) {
                        add(-1);
                    } else {
                        add(list.get(indexMax));
                    }

                    int indexMin = binarySearchMin(0, list.size(), x -> list.get(x) >= val);
                    if (indexMin == list.size()) {
                        add(-1);
                    } else {
                        add(list.get(indexMin));
                    }
                }});
            }
            return ans;
        }

        //judgeRange = [low,high-1], returnRange = [low,high]
        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        // 寻找符合条件的最大值
        //judgeRange = [low,high-1], returnRange = [low-1,high-1]
        public int binarySearchMax(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        public void inorder(TreeNode node, Consumer<Integer> visitor) {
            if (node == null) {
                return;
            }
            inorder(node.left, visitor);
            visitor.accept(node.val);
            inorder(node.right, visitor);
        }

    }

    public static void main(String[] args) {
        new P2476().new Solution().closestNodes(BinaryTreeTestUtil.build("[6,2,13,1,4,9,15,null,null,null,null,null,null,14]"), Arrays.asList(2, 5, 16));
    }

}
