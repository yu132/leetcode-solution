package redo.Util.ag.rangeMinMaxQuery;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: RMQIndex  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class RMQIndex {

    static int[][] rmqMaxIndexInit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][(int)(Math.log(n + 1) / Math.log(2)) + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; (1 << j) <= n; ++j) {
            for (int i = 0; i + (1 << j) - 1 < n; ++i) {
                if (arr[dp[i][j - 1]] > arr[dp[i + (1 << (j - 1))][j - 1]]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i + (1 << (j - 1))][j - 1];
                }
            }
        }
        return dp;
    }

    // 区间为[start,end]，end是区间内的
    static int queryMaxIndex(int start, int end, int[][] dp, int[] arr) {
        int mid = (int)(Math.log(end - start + 1) / Math.log(2));
        if (arr[dp[start][mid]] > arr[dp[end - (1 << mid) + 1][mid]]) {
            return dp[start][mid];
        } else {
            return dp[end - (1 << mid) + 1][mid];
        }
    }

    @Test
    public void test() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int[] arr = new int[10000];

        Arrays.setAll(arr, (x) -> random.nextInt(10000));//

        int[][] dp = rmqMaxIndexInit(arr);

        for (int i = 0; i < 100; ++i) {
            for (int j = i + 1; j < 100; ++j) {
                // System.out.println(i + " " + j + " " + query(i + 1, j, dp));
                int max = 0, mIndex = 0;
                for (int k = i; k < j; ++k) {
                    if (arr[k] > max) {
                        max = arr[k];
                        mIndex = k;
                    }
                }
                System.out.println(i + " " + j);
                Assert.assertEquals(mIndex, queryMaxIndex(i, j - 1, dp, arr));
            }
        }

    }

}
