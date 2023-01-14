package old._0800_0899;

import java.util.Arrays;

/**  
 * @ClassName: _820  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _820 {

    class Solution {
        public int minimumLengthEncoding(String[] words) {

            Arrays.sort(words, (a, b) -> {
                return Integer.compare(b.length(), a.length());
            });

            TireNode root  = new TireNode();

            int      count = 0;

            for (String str : words) {
                TireNode node  = root;
                boolean  isNew = false;
                for (int i = str.length() - 1; i >= 0; --i) {
                    int index = str.charAt(i) - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TireNode();
                        isNew                = true;
                    }
                    node = node.children[index];
                }
                if (isNew) {
                    count += str.length() + 1;
                }
            }

            return count;
        }

        class TireNode {
            TireNode[] children = new TireNode[26];
        }
    }

    public static void main(String[] args) {
        System.out.println(new _820().new Solution().minimumLengthEncoding(new String[] {"time", "atime", "btime"}));
    }
}
