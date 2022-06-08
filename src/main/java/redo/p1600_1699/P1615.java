package redo.p1600_1699;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1615  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1615 {

    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] count = new int[n];
            Set<Integer> containRoads = new HashSet<>();
            for (int[] road : roads) {
                ++count[road[0]];
                ++count[road[1]];
                containRoads.add(road[0] + 101 * road[1]);
            }
            List<Integer> maxIndex = new ArrayList<>();
            List<Integer> max2Index = new ArrayList<>();
            int max = -1, max2 = -1;
            for (int i = 0; i < n; ++i) {
                if (count[i] > max) {
                    max2 = max;
                    max = count[i];
                    max2Index.clear();
                    max2Index.addAll(maxIndex);
                    maxIndex.clear();
                    maxIndex.add(i);
                } else if (count[i] == max) {
                    maxIndex.add(i);
                } else if (count[i] > max2) {
                    max2 = count[i];
                    max2Index.clear();
                    max2Index.add(i);
                } else if (count[i] == max2) {
                    max2Index.add(i);
                }
            }

            if (maxIndex.size() >= 2) {
                for (int i = 0; i < maxIndex.size(); ++i) {
                    for (int j = i + 1; j < maxIndex.size(); ++j) {
                        if (!connect(maxIndex.get(i), maxIndex.get(j), containRoads)) {
                            return 2 * max;
                        }
                    }
                }
                return 2 * max - 1;
            }

            for (int i = 0; i < max2Index.size(); ++i) {
                if (!connect(maxIndex.get(0), max2Index.get(i), containRoads)) {
                    return max + max2;
                }
            }
            return max + max2 - 1;
        }

        public boolean connect(int index1, int index2, Set<Integer> containRoads) {
            return containRoads.contains(index1 + 101 * index2) || containRoads.contains(index2 + 101 * index1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maximalNetworkRank(4, Arrs.build2D("[[0,1],[0,3],[1,2],[1,3]]")));
        Assert.assertEquals(5, s.maximalNetworkRank(5, Arrs.build2D("[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]")));
        Assert.assertEquals(5, s.maximalNetworkRank(8, Arrs.build2D("[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]")));
        Assert.assertEquals(4, s.maximalNetworkRank(5, Arrs.build2D("[[2,3],[0,3],[0,4],[4,1]]")));

    }

}
