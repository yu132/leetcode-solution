package old._0600_0699;

import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: _636  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月1日  
 *  
 */
public class _636 {

    class Solution {

        class Node {
            int start;
            int minus;

            public Node(int start) {
                super();
                this.start = start;
            }
        }

        public int[] exclusiveTime(int n, List<String> logs) {
            int[]            ans   = new int[n];
            LinkedList<Node> stack = new LinkedList<>();
            stack.add(new Node(0));

            for (String each : logs) {
                String[] sp = each.split(":");
                if (sp[1].equals("start")) {
                    stack.addFirst(new Node(Integer.valueOf(sp[2])));
                } else {
                    Node node = stack.removeFirst();
                    int  last = Integer.valueOf(sp[2]) + 1 - node.start;
                    ans[Integer.valueOf(sp[0])] += last - node.minus;
                    stack.getFirst().minus      += last;
                }
            }

            return ans;
        }
    }

}
