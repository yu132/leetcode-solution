package redo.Util.ag.rangeMinMaxQuery;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

/**
 * @author 余定邦
 * @ClassName: RMQUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月20日
 */
public class RMQUtil {

    // ST表法， ST TABLE

    // op 必须满足某些要求，需要为可重复贡献问题，例如max，min，gcd三类能满足
    int[][] rmqOpInit(int[] arr, BiFunction<Integer, Integer, Integer> op) {
        int n = arr.length;
        int[][] dp = new int[n][(int) (Math.log(n + 1) / Math.log(2)) + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = arr[i];
        }
        for (int j = 1; (1 << j) <= n; ++j) {
            for (int i = 0; i + (1 << j) - 1 < n; ++i) {
                dp[i][j] = op.apply(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
        return dp;
    }

    int queryOpRes(int start, int end, int[][] dp, BiFunction<Integer, Integer, Integer> op) {
        int mid = (int) (Math.log(end - start + 1) / Math.log(2));
        return op.apply(dp[start][mid], dp[end - (1 << mid) + 1][mid]);
    }


    //O(nlogn)
    static int[][] rmqMaxInit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][(int) (Math.log(n + 1) / Math.log(2)) + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = arr[i];
        }
        for (int j = 1; (1 << j) <= n; ++j) {
            for (int i = 0; i + (1 << j) - 1 < n; ++i) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
        return dp;
    }

    // 区间为[start,end]，end是区间内的, O(1)
    static int queryMax(int start, int end, int[][] dp) {
        int mid = (int) (Math.log(end - start + 1) / Math.log(2));
        return Math.max(dp[start][mid], dp[end - (1 << mid) + 1][mid]);
    }

    static int[][] rmqMinInit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][(int) (Math.log(n + 1) / Math.log(2)) + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = arr[i];
        }
        for (int j = 1; (1 << j) <= n; ++j) {
            for (int i = 0; i + (1 << j) - 1 < n; ++i) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + (1 << (j - 1))][j - 1]);
            }
        }
        return dp;
    }

    // 区间为[start,end]，end是区间内的
    static int queryMin(int start, int end, int[][] dp) {
        int mid = (int) (Math.log(end - start + 1) / Math.log(2));
        return Math.min(dp[start][mid], dp[end - (1 << mid) + 1][mid]);
    }


    @Test
    public void test() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        int[] arr = new int[10000];

        Arrays.setAll(arr, (x) -> random.nextInt(10000));//

        int[][] dp = rmqMaxInit(arr);

        for (int i = 0; i < 100; ++i) {
            for (int j = i + 1; j < 100; ++j) {
                // System.out.println(i + " " + j + " " + query(i + 1, j, dp));
                int max = 0;
                for (int k = i; k < j; ++k) {
                    max = Math.max(max, arr[k]);
                }
                System.out.println(i + " " + j);
                Assert.assertEquals(max, queryMax(i, j - 1, dp));
            }
        }

    }

}
