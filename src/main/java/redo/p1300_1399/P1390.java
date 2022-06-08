package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1390  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1390 {

    static//

    class Solution {
        public int sumFourDivisors(int[] nums) {
            int n = max(nums);

            List<Integer> primes = getPrimes(n / 2 + 1);

            Map<Integer, Integer> fdAndSumMapping = new HashMap<>();

            for (int prime : primes) {
                int num = prime * prime * prime;
                if (num <= n) {
                    fdAndSumMapping.put(num, 1 + prime + prime * prime + prime * prime * prime);
                }
            }

            for (int i = 0; i < primes.size(); ++i) {
                for (int j = i + 1; j < primes.size(); ++j) {
                    int num = primes.get(i) * primes.get(j);
                    if (num <= n) {
                        fdAndSumMapping.put(num, 1 + primes.get(i) + primes.get(j) + primes.get(i) * primes.get(j));
                    }
                }
            }

            int ans = 0;

            for (int x : nums) {
                if (fdAndSumMapping.containsKey(x)) {
                    ans += fdAndSumMapping.get(x);
                }
            }

            return ans;
        }

        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        public static List<Integer> getPrimes(int n) {
            if (n <= 1) {
                return Collections.emptyList();
            }
            List<Integer> primes = new ArrayList<Integer>((int)(n / Math.log(n)));
            boolean[] isNotPrime = new boolean[n + 1];
            for (int i = 2; i <= n; ++i) {
                if (!isNotPrime[i]) {
                    primes.add(i);
                }
                for (int j = 0; j < primes.size() && i * primes.get(j) <= n; ++j) {
                    isNotPrime[i * primes.get(j)] = true;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            return primes;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(32, s.sumFourDivisors(new int[] {21, 4, 7}));
        Assert.assertEquals(0, s.sumFourDivisors(new int[] {1}));
    }

}
