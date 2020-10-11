package _0700_0799;

import java.util.LinkedList;

/**  
 * @ClassName: _739  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月18日  
 *  
 */
public class _739 {

    class Solution {

        class Node {
            int val;
            int index;

            public Node(int val, int index) {
                super();
                this.val   = val;
                this.index = index;
            }
        }

        public int[] dailyTemperatures(int[] T) {
            LinkedList<Node> queue = new LinkedList<>();

            int[]            ans   = new int[T.length];

            for (int i = 0; i < T.length; ++i) {
                while (!queue.isEmpty() && queue.getFirst().val < T[i]) {
                    Node n = queue.removeFirst();
                    ans[n.index] = i - n.index;
                }
                queue.addFirst(new Node(T[i], i));
            }

            return ans;
        }
    }

}
