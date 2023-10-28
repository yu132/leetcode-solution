package redo.p2500_2599;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2523 {

    static
            //
    class Solution {

        static List<Integer> primes = new ArrayList<>();

        static {
            primes = getPrimes(1000000);
        }

        public int[] closestPrimes(int left, int right) {
            int start = Collections.binarySearch(primes, left);
            if (start < 0) {
                start = -start - 1;
            }
            if (start >= primes.size() - 1 || primes.get(start + 1) > right) {
                return new int[]{-1, -1};
            }
            int[] ans = new int[]{primes.get(start), primes.get(start + 1)};
            for (int i = start + 1; i < primes.size() - 1 && primes.get(i + 1) <= right; ++i) {
                if (primes.get(i + 1) - primes.get(i) < ans[1] - ans[0]) {
                    ans = new int[]{primes.get(i), primes.get(i + 1)};
                }
            }
            return ans;
        }

        public static List<Integer> getPrimes(int n) {
            if (n <= 1) {
                return Collections.emptyList();
            }
            List<Integer> primes = new ArrayList<Integer>((int) (n / Math.log(n)));
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

}
