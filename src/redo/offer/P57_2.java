package redo.offer;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P57_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P57_2 {

    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> ans = new ArrayList<>();
            int low = 1, high = 2, sum = 1;
            while (low < target) {
                if (target == sum) {
                    if (high - low > 1) {
                        int[] arr = new int[high - low];
                        for (int i = low; i < high; ++i) {
                            arr[i - low] = i;
                        }
                        ans.add(arr);
                    }
                }
                if (target > sum) {
                    sum += high++;
                } else {
                    sum -= low++;
                }
            }
            return ans.toArray(new int[0][]);
        }
    }

}
