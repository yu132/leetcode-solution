package redo.Util.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: Prime  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class Prime {

    public int countPrimesNotIncludeN(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
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
        return primes.size();
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



    @Test
    public void test() {
        System.out.println(getPrimes(Integer.MAX_VALUE));
    }

    // public static void main(String[] args) {
    // int count = 0, n = 10000000;
    //
    // long diff = 0, diffG = 0;
    //
    // List<Integer> primes = getPrimes(n);
    //
    // BinaryIndexedTree bit = new BinaryIndexedTree(n);
    //
    // for (int i = 0; i < primes.size(); ++i) {
    // bit.add(primes.get(i), 1);
    // }
    //
    // for (int i = 2; i < n; ++i) {
    // if (i % 1000 == 0) {
    // System.out.println(i);
    // }
    // int c = bit.getSumInclude(i);
    // int comp = (int)(i / Math.log(i) * 1.12);
    // if (c > comp) {
    // ++count;
    // diff += c - comp;
    // } else {
    // diffG += comp - c;
    // }
    // }
    // System.out.println(n / Math.log(n) * 1.18);
    // System.out.println((double)count / n);
    // System.out.println((double)diff / count);
    // System.out.println(diff);
    //
    // System.out.println((double)diffG / n);
    // System.out.println(diffG);
    // }

}
