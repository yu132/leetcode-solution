package lcci.M08;

import java.util.List;

/**  
 * @ClassName: M08_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月4日  
 *  
 */
public class M08_06 {

    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            hanota(A.size(), A, B, C);
        }

        public void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
            if (n == 1) {
                push(C, pop(A));
                return;
            }
            hanota(n - 1, A, C, B);
            push(C, pop(A));
            hanota(n - 1, B, A, C);
        }

        private int pop(List<Integer> a) {
            return a.remove(a.size() - 1);
        }

        private void push(List<Integer> a, int x) {
            a.add(x);
        }
    }

}
