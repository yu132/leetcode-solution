package redo.mianshi.p08;

import java.util.Arrays;

/**  
 * @ClassName: P08_13  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_13 {

    class Solution {
        public int pileBox(int[][] box) {
            Arrays.sort(box, (a, b) -> Integer.compare(a[2], b[2]));

            int n = box.length, max = 0;

            int[] dp = new int[n];

            for (int i = 0; i < n; ++i) {

                max = Math.max(max, dp[i] = box[i][2]);

                for (int j = 0; j < i; ++j) {
                    if (box[i][0] > box[j][0] && box[i][1] > box[j][1]
                        && box[i][2] > box[j][2]) {
                        dp[i] = Math.max(dp[i], box[i][2] + dp[j]);
                        max = Math.max(max, dp[i]);
                    }
                }
            }

            return max;
        }
    }

}
