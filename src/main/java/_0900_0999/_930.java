package _0900_0999;

import java.util.ArrayList;

/**  
 * @ClassName: _930  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月21日  
 *  
 */
public class _930 {

    class Solution {
        public int numSubarraysWithSum(int[] A, int S) {
            if (S == 0) {
                int last = 0, count = 0;
                for (int i = 0; i < A.length; ++i) {
                    if (A[i] == 1) {
                        int n = i - last;
                        count += n * (n + 1) / 2;
                        last   = i + 1;
                    }
                }
                int n = A.length - last;
                count += n * (n + 1) / 2;
                return count;
            }
            ArrayList<Integer> list = new ArrayList<>();
            int                last = 0;
            for (int i = 0; i < A.length; ++i) {
                if (A[i] == 1) {
                    list.add(i - last);
                    last = i + 1;
                }
            }
            list.add(A.length - last);
            int l = 0, h = S, count = 0;
            for (; h < list.size(); ++l, ++h) {
                count += (list.get(l) + 1) * (list.get(h) + 1);
            }
            return count;
        }
    }

}
