package redo.offer2.p08;

import java.util.List;

/**  
 * @ClassName: P08_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_06 {

    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            helper(A, C, B, A.size());
        }

        public void helper(List<Integer> src, List<Integer> target,
            List<Integer> aux, int num) {
            if (num == 0) {
                return;
            }
            helper(src, aux, target, num - 1);
            target.add(src.remove(src.size() - 1));
            helper(aux, target, src, num - 1);
        }
    }

}
