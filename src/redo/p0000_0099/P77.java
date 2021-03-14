package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P77  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P77 {

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            comb(1, new ArrayList<>(), k, n, ans);
            return ans;
        }

        void comb(int index, List<Integer> list, int k, int n,
            List<List<Integer>> ans) {

            if (list.size() == k) {
                ans.add(new ArrayList<>(list));
                return;
            }

            if (index == n + 1) {
                return;
            }

            if (n - index + 1 < k - list.size()) {
                return;
            }

            comb(index + 1, list, k, n, ans);

            list.add(index);
            comb(index + 1, list, k, n, ans);
            list.remove(list.size() - 1);

        }
    }

}
