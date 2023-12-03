package redo.p2700_2799;

import java.util.*;

public class P2761 {

    static
            //

    class Solution {

        static List<Integer> primes;
        static Set<Integer> primesSet;

        static {
            primes = getPrimes(1000_000);
            primesSet = new HashSet<>(primes);
        }


        public List<List<Integer>> findPrimePairs(int n) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < primes.size() && primes.get(i) <= n / 2; ++i) {
                if (primesSet.contains(n - primes.get(i))) {
                    ans.add(Arrays.asList(primes.get(i), n - primes.get(i)));
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
