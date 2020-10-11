package _1100_1199;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: _1166  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1166 {

    class FileSystem {

        class TreeNode {
            Map<String, TreeNode> children = new HashMap<>();
            int val;

            public TreeNode(int val) {
                super();
                this.val = val;
            }
        }

        private TreeNode root = new TreeNode(0);

        public FileSystem() {}

        public boolean createPath(String path, int value) {
            if (path.length() < 2) {
                return false;
            }
            String[] paths = path.substring(1).split("/");
            TreeNode node  = root;
            for (int i = 0; i < paths.length; ++i) {
                TreeNode next = node.children.get(paths[i]);
                if (next == null) {
                    if (i == paths.length - 1) {
                        node.children.put(paths[i], new TreeNode(value));
                        return true;
                    }
                    return false;
                } else {
                    if (i == paths.length - 1) {
                        return false;
                    }
                    node = next;
                }
            }
            return false;
        }

        public int get(String path) {
            String[] paths = path.substring(1).split("/");
            TreeNode node  = root;
            for (int i = 0; i < paths.length; ++i) {
                TreeNode next = node.children.get(paths[i]);
                if (next == null) {
                    return -1;
                } else {
                    if (i == paths.length - 1) {
                        return next.val;
                    }
                    node = next;
                }
            }
            return -1;
        }
    }

}
