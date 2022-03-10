package redo.p0400_0499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P406  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P406 {

    class Solution {
        public int[][] reconstructQueue(int[][] people) {

            int n = people.length;

            Arrays.sort(people, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            List<int[]> ans = new ArrayList<>(n);

            for (int[] p : people) {
                ans.add(p[1], p);
            }

            return ans.toArray(new int[0][]);
        }
    }

}
