package _0900_0999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.TreeNode;
import utils.SerializeBT;

/**  
 * @ClassName: _987  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _987 {

    class Solution {

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            int                low   = 1, high = 0;
            LinkedList<Node>   queue = new LinkedList<>();
            Map<Integer, Pack> map   = new HashMap<>();
            queue.addLast(new Node(0, 0, root, true));
            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (!map.containsKey(node.x)) {
                    map.put(node.x, new Pack(0));
                    if (node.left) {
                        --low;
                    } else {
                        ++high;
                    }
                }
                Pack pack = map.get(node.x);
                if (node.y > pack.y) {
                    Collections.sort(pack.now);
                    pack.ans.addAll(pack.now);
                    pack.now.clear();
                    pack.y = node.y;
                }
                pack.now.add(node.node.val);
                if (node.node.left != null) {
                    queue.addLast(new Node(node.x - 1, node.y + 1, node.node.left, true));
                }

                if (node.node.right != null) {
                    queue.addLast(new Node(node.x + 1, node.y + 1, node.node.right, false));
                }
            }

            List<List<Integer>> ans = new ArrayList<>();

            for (int i = low; i <= high; ++i) {
                Pack pack = map.get(i);

                Collections.sort(pack.now);
                pack.ans.addAll(pack.now);

                ans.add(pack.ans);
            }

            return ans;
        }

        class Pack {
            int y;
            List<Integer> ans;
            List<Integer> now;

            public Pack(int y) {
                super();
                this.y = y;
                ans    = new ArrayList<>();
                now    = new ArrayList<>();
            }
        }

        class Node {
            int x;
            int y;
            TreeNode node;
            boolean left;

            public Node(int x, int y, TreeNode node, boolean left) {
                super();
                this.x    = x;
                this.y    = y;
                this.node = node;
                this.left = left;
            }
        }

    }

    public static void main(String[] args) {
        SerializeBT util = new SerializeBT();
        TreeNode    root = util.deserialize("[5,2,3,4,6,1,7]");
        System.out.println(new _987().new Solution().verticalTraversal(root));
    }
}
