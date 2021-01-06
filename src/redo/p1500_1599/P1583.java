package redo.p1500_1599;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1583  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1583 {

    class Solution {
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            int[][] view = new int[n][n];
            for (int i = 0; i < preferences.length; ++i) {
                for (int j = 0; j < preferences[0].length; ++j) {
                    view[i][preferences[i][j]] = j;
                }
            }

            Map<Integer, Integer> pairsMapping = new HashMap<>();

            for (int[] pair : pairs) {
                pairsMapping.put(pair[0], pair[1]);
                pairsMapping.put(pair[1], pair[0]);
            }

            int unhappy = 0;
            for (int i = 0; i < n; ++i) {
                int pair = pairsMapping.get(i);
                for (int j = 0; j < preferences[i].length; ++j) {
                    int preferencePair = preferences[i][j];
                    if (preferencePair == pair) {// happy
                        break;
                    }
                    int preferencePairPair = pairsMapping.get(preferencePair);
                    if (view[preferencePair][preferencePairPair] > view[preferencePair][i]) {
                        ++unhappy;
                        break;
                    }
                }
            }

            return unhappy;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2,
            s.unhappyFriends(4, Arrs.build2D("[[1,2,3],[3,2,0],[3,1,0],[1,2,0]]"), Arrs.build2D("[[0,1],[2,3]]")));
        Assert.assertEquals(0, s.unhappyFriends(2, Arrs.build2D("[[1],[0]]"), Arrs.build2D("[[1,0]]")));
        Assert.assertEquals(4,
            s.unhappyFriends(4, Arrs.build2D("[[1,3,2],[2,3,0],[1,3,0],[0,2,1]]"), Arrs.build2D("[[1,3],[0,2]]")));

    }

}
