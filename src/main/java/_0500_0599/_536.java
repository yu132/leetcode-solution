package _0500_0599;

import model.TreeNode;

/**  
 * @ClassName: _536  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月13日  
 *  
 */
public class _536 {

    class Solution {
        public TreeNode str2tree(String s) {
            this.s = s;
            return tree();
        }

        int index = 0;
        String s;

        public TreeNode tree() {
            if (index == s.length()) {
                return null;
            } else if (s.charAt(index) == ')') {
                ++index;
                return null;
            }

            int sign = 1;

            if (s.charAt(index) == '-') {
                ++index;
                sign = -1;
            }

            int start = index;
            while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                ++index;
            }
            TreeNode node = new TreeNode(Integer.valueOf(s.substring(start, index)) * sign);
            node.left  = node();
            node.right = node();
            return node;
        }

        public TreeNode node() {
            if (index == s.length()) {
                return null;
            }
            if (s.charAt(index) != '(') {
                return null;
            }
            ++index;
            TreeNode ans = tree();
            ++index;
            return ans;
        }
    }

}
