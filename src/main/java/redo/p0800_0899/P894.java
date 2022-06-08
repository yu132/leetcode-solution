package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.TreeNode;

/**  
 * @ClassName: P894  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P894 {

    class Solution {

        Map<Integer, List<TreeNode>> dp = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int N) {
            if (N % 2 == 0) {
                return Collections.emptyList();
            }
            dp.put(1, Arrays.asList(new TreeNode(0)));
            return helper(N);
        }

        public List<TreeNode> helper(int N) {
            if (dp.containsKey(N)) {
                return dp.get(N);
            }
            List<TreeNode> ans = new ArrayList<>();
            for (int i = 1; i <= N - 2; i += 2) {
                List<TreeNode> left = helper(i), right = helper(N - 1 - i);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(0);
                        node.left = l;
                        node.right = r;
                        ans.add(node);
                    }
                }
            }
            dp.put(N, ans);
            return ans;
        }
    }

}
