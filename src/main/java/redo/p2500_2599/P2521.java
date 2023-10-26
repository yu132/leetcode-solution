package redo.p2500_2599;

import java.util.*;

public class P2521 {

    static
            //
    class Solution {

        static {
            primes = getPrimes(1000);
        }

        static List<Integer> primes;

        public int distinctPrimeFactors(int[] nums) {
            Set<Integer> ans = new HashSet<>();
            for (int num : nums) {
                for (int i = 0; i < primes.size(); ++i) {
                    if (num % primes.get(i) == 0) {
                        ans.add(primes.get(i));
                    }
                }
            }
            return ans.size();
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
