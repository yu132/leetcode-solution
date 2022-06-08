package redo.offer2.p04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.TreeNode;

/**  
 * @ClassName: P04_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_09 {

    class Solution {
        public List<List<Integer>> BSTSequences(TreeNode root) {
            if (root == null) {
                return Arrays.asList(Collections.emptyList());
            }
            return helper(root);
        }

        public List<List<Integer>> helper(TreeNode root) {
            if (root.left == null && root.right == null) {
                return Arrays.asList(Arrays.asList(root.val));
            }

            List<List<Integer>> ans = new ArrayList<>();
            if (root.left == null) {
                for (List<Integer> list : helper(root.right)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(root.val);
                    l.addAll(list);
                    ans.add(l);
                }
                return ans;
            }
            if (root.right == null) {
                for (List<Integer> list : helper(root.left)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(root.val);
                    l.addAll(list);
                    ans.add(l);
                }
                return ans;
            }
            List<List<Integer>> ls = helper(root.left), rs = helper(root.right);

            for (List<Integer> l : ls) {
                for (List<Integer> r : rs) {
                    List<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    backtrack(0, 0, l, r, list, ans);
                }
            }

            return ans;
        }

        void backtrack(int ll, int lr, List<Integer> l, List<Integer> r,
            List<Integer> list, List<List<Integer>> ans) {
            if (ll == l.size() && lr == r.size()) {
                ans.add(new ArrayList<>(list));
                return;
            }

            if (ll != l.size()) {
                list.add(l.get(ll));
                backtrack(ll + 1, lr, l, r, list, ans);
                list.remove(list.size() - 1);
            }

            if (lr != r.size()) {
                list.add(r.get(lr));
                backtrack(ll, lr + 1, l, r, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

}
