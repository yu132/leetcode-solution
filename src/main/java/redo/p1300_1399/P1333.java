package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1333  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1333 {

    // 0:id; 1:rating; 2:vegFriend; 3:price; 4:distance
    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            boolean vegOnly = (veganFriendly == 1);
            List<int[]> inLimit = new ArrayList<>();
            for (int[] restaurant : restaurants) {
                if (vegOnly && restaurant[2] == 0) {
                    continue;
                }
                if (restaurant[3] > maxPrice) {
                    continue;
                }
                if (restaurant[4] > maxDistance) {
                    continue;
                }
                inLimit.add(restaurant);
            }
            Collections.sort(inLimit, (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(b[0], a[0]);
            });
            List<Integer> ans = new ArrayList<>(inLimit.size());
            for (int[] restaurant : inLimit) {
                ans.add(restaurant[0]);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(3, 1, 5), s.filterRestaurants(
            Arrs.build2D("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]"), 1, 50, 10));
        Assert.assertEquals(Arrays.asList(4, 3, 2, 1, 5), s.filterRestaurants(
            Arrs.build2D("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]"), 0, 50, 10));
        Assert.assertEquals(Arrays.asList(4, 5), s.filterRestaurants(
            Arrs.build2D("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]"), 0, 30, 3));

    }
}
