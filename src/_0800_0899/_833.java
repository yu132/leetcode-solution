package _0800_0899;

import java.util.Arrays;

/**  
 * @ClassName: _833  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _833 {

    class Solution {
        public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

            Node[] nodes = new Node[indexes.length];

            for (int i = 0; i < indexes.length; ++i) {
                nodes[i] = new Node(indexes[i], sources[i], targets[i]);
            }

            Arrays.sort(nodes, (a, b) -> {
                return Integer.compare(a.index, b.index);
            });

            StringBuilder ans   = new StringBuilder(S.length());

            int           index = 0;

            for (Node node : nodes) {
                ans.append(S.substring(index, node.index));
                if (S.substring(node.index, node.index + node.src.length()).equals(node.src)) {
                    ans.append(node.tar);
                    index = node.index + node.src.length();
                } else {
                    index = node.index;
                }
            }

            ans.append(S.substring(index, S.length()));

            return ans.toString();
        }

        class Node {
            int index;
            String src;
            String tar;

            public Node(int index, String src, String tar) {
                super();
                this.index = index;
                this.src   = src;
                this.tar   = tar;
            }
        }
    }

}
