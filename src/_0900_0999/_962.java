package _0900_0999;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _962  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _962 {

    class Solution {
        public int maxWidthRamp(int[] A) {
            List<Integer> stack   = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();
            int           ans     = 0;
            stack.add(A[0]);
            indexes.add(0);
            for (int i = 0; i < A.length; ++i) {
                int index = reverseBinarySearch(stack, A[i]);
                if (index < indexes.size()) {
                    ans = Math.max(ans, i - indexes.get(index));
                }
                if (stack.get(stack.size() - 1) > A[i]) {
                    stack.add(A[i]);
                    indexes.add(i);
                }
            }
            return ans;
        }

        public int reverseBinarySearch(List<Integer> list, int num) {
            int low = 0, high = list.size();
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (list.get(mid) < num) {
                    high = mid;
                } else if (list.get(mid) > num) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            return low;
        }
    }

}
