package old._0200_0299;

import model.TreeNode;

/**  
 * @ClassName: _222  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _222 {

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = getHeight(root.left), r = getHeight(root.right);
            if (l == r) {
                return (int)(Math.pow(2, l) + countNodes(root.right));
            } else {
                return (int)(Math.pow(2, r) + countNodes(root.left));
            }
        }

        public int getHeight(TreeNode root) {
            int h = 0;
            while (root != null) {
                root = root.left;
                ++h;
            }
            return h;
        }
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _3 = new TreeNode(3);
        TreeNode _6 = new TreeNode(6);

        _1.right = _3;
        _3.left  = _6;

        System.out.println(new _222().new Solution().countNodes(_1));
    }

}
