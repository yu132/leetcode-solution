package _1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _1229  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1229 {

    class Solution {
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

            Arrays.sort(slots1, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            Arrays.sort(slots2, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            int i1 = 0, i2 = 0;

            while (i2 != slots2.length && i1 != slots1.length) {
                while (i2 != slots2.length && slots1[i1][0] >= slots2[i2][1]) {
                    ++i2;
                }
                if (i2 == slots2.length) {
                    return Collections.emptyList();
                }
                while (i1 != slots1.length && slots1[i1][1] <= slots2[i2][0]) {
                    ++i1;
                }
                if (i1 == slots1.length) {
                    return Collections.emptyList();
                }
                if (Math.min(slots1[i1][1], slots2[i2][1]) - Math.max(slots1[i1][0], slots2[i2][0]) >= duration) {
                    List<Integer> list  = new ArrayList<>();
                    int           start = Math.max(slots1[i1][0], slots2[i2][0]);
                    list.add(start);
                    list.add(start + duration);
                    return list;
                }
                if (slots1[i1][1] < slots2[i2][1]) {
                    ++i1;
                } else {
                    ++i2;
                }
            }
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        new _1229().new Solution().minAvailableDuration(new int[][] {{0, 2}}, new int[][] {{1, 3}}, 2);
    }

}
