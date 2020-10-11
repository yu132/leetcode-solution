package _1100_1199;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;
import utils.SerializeBT;

/**  
 * @ClassName: _1145  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月5日  
 *  
 */
public class _1145 {

    class Solution {

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            Map<TreeNode, Pair> map = new HashMap<>();
            count(root, map);
            return dfs(root, x, 0, map);
        }

        public boolean dfs(TreeNode root, int x, int nodeNumFromFather, Map<TreeNode, Pair> map) {
            if (root == null) {
                return false;
            }
            Pair p = map.get(root);
            if (root.val == x) {
                int f = nodeNumFromFather, l = p.left, r = p.right;
                return f > l + r + 1 || l > f + r + 1 || r > f + l + 1;
            } else {
                return dfs(root.left, x, nodeNumFromFather + p.right + 1, map)
                    || dfs(root.right, x, nodeNumFromFather + p.left + 1, map);
            }
        }

        public int count(TreeNode root, Map<TreeNode, Pair> map) {
            if (root == null) {
                return 0;
            }
            int left  = count(root.left, map);
            int right = count(root.right, map);
            map.put(root, new Pair(left, right));
            return left + right + 1;
        }

        class Pair {
            int left;
            int right;

            public Pair(int left, int right) {
                super();
                this.left  = left;
                this.right = right;
            }
        }
    }

    public static void main(String[] args) {
        SerializeBT sbt = new SerializeBT();
        TreeNode    t   = sbt.deserialize("[1,2,3,4,5,6,7,8,9,10,11]");
        System.out.println(new _1145().new Solution().btreeGameWinningMove(t, 11, 3));
    }

}
