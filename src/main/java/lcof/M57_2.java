package lcof;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: M57_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class M57_2 {

    class Solution {
        public int[][] findContinuousSequence(int target) {

            int         from = 1, to = 2, sum = 3;

            List<int[]> list = new ArrayList<>();

            while (true) {
                if (sum > target) {
                    if (to - from + 1 <= 2) {
                        break;
                    }
                    sum -= from;
                    ++from;
                } else {// sum>=target
                    if (sum == target) {
                        list.add(range(from, to));
                    }
                    ++to;
                    sum += to;
                }
            }

            return list.toArray(new int[list.size()][]);
        }

        public int[] range(int from, int to) {
            int[] arr = new int[to - from + 1];
            for (int i = from; i <= to; ++i) {
                arr[i - from] = i;
            }
            return arr;
        }
    }

}
