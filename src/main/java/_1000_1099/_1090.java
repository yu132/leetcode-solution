package _1000_1099;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _1090  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月23日  
 *  
 */
public class _1090 {

    class Solution {

        class Node {
            int val;
            int label;

            public Node(int val, int label) {
                super();
                this.val   = val;
                this.label = label;
            }
        }

        public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < values.length; ++i) {
                list.add(new Node(values[i], labels[i]));
            }
            Collections.sort(list, (a, b) -> {
                return Integer.compare(b.val, a.val);
            });
            int   sum  = 0, count = 0;
            int[] used = new int[20001];
            for (Node n : list) {
                if (count == num_wanted) {
                    break;
                }

                if (used[n.label] == use_limit) {
                    continue;
                }

                ++used[n.label];
                sum += n.val;
                ++count;
            }

            return sum;
        }
    }

}
