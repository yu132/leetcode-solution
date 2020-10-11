package _0400_0499;

import java.util.ArrayList;
import java.util.Arrays;

/**  
 * @ClassName: _406  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _406 {

    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(b[0], a[0]);
                }
            });

            ArrayList<int[]> list = new ArrayList<>();

            for (int[] p : people) {
                list.add(p[1], p);
            }

            return list.toArray(new int[people.length][2]);
        }
    }

}
