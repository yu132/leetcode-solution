package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1626  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1626 {

    static//

    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            Data[] datas = new Data[scores.length];
            for (int i = 0; i < scores.length; ++i) {
                datas[i] = new Data(scores[i], ages[i]);
            }
            Arrays.sort(datas, (a, b) -> {
                if (a.age == b.age) {
                    return Integer.compare(a.score, b.score);
                }
                return Integer.compare(a.age, b.age);
            });

            int[] dp = new int[scores.length];

            int max = 0;

            for (int i = 0; i < scores.length; ++i) {
                dp[i] = datas[i].score;
                for (int j = 0; j < i; ++j) {
                    if (datas[j].score <= datas[i].score) {
                        dp[i] = Math.max(dp[i], dp[j] + datas[i].score);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }

        static class Data {
            int score, age;

            public Data(int score, int age) {
                super();
                this.score = score;
                this.age = age;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(34, s.bestTeamScore(new int[] {1, 3, 5, 10, 15}, new int[] {1, 2, 3, 4, 5}));
        Assert.assertEquals(16, s.bestTeamScore(new int[] {4, 5, 6, 5}, new int[] {2, 1, 2, 1}));
        Assert.assertEquals(6, s.bestTeamScore(new int[] {1, 2, 3, 5}, new int[] {8, 9, 10, 1}));
    }

}
