//package redo.p2500_2599;
//
//import java.util.HashSet;
//
//public class P2572 {
//
//    static
//            //
//    class Solution {
//
//        int[] exc = new int[]{4, 9, 16, 25};
//
//
//        public int squareFreeSubsets(int[] nums) {
//            HashSet<Integer> set = new HashSet<>();
//            outer:
//            for (int nuam : nums) {
//                for (int t : exc) {
//                    if (num % t == 0) {
//                        conatinue outer;
//                    }
//                }
//                set.add(num);
//            }
//            int ans = pow(2, count, MOD);
//            return minus(ans, 1, MOD);
//        }
//
//        public final static int MOD = 1_000_000_007;
//
//        int minus(long a, long b, int mod) {// a > b
//            return (int) ((a % mod - b % mod + mod) % mod);// 加mod是为了防止为负数
//        }
//
//        //模数不能求模，如果需要，要先求欧拉函数，再对欧拉函数的结果求模，见上eulerFastPow，还需要mod是一个质数
//        int pow(long base, long exp, int mod) {
//            long ans = 1;
//            base %= mod;
//            while (exp > 0) {
//                if (exp % 2 != 0) {
//                    ans = (ans * base) % mod;
//                }
//                exp >>= 1;
//                base = (base * base) % mod;
//            }
//            return (int) ans;
//        }
//    }
//
//}
