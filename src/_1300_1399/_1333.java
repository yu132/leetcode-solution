package _1300_1399;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1333  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月28日  
 *  
 */
public class _1333 {

    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

            ArrayList<int[]> availble = new ArrayList<>();

            for (int[] each : restaurants) {
                if (veganFriendly == 1 && each[2] != 1) {
                    continue;
                }
                if (each[3] > maxPrice) {
                    continue;
                }
                if (each[4] > maxDistance) {
                    continue;
                }
                availble.add(each);
            }

            availble.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(b[1], a[1]);
            });

            List<Integer> list = new ArrayList<>();

            for (int[] each : availble) {
                list.add(each[0]);
            }

            return list;
        }
    }

}
