package redo.Util.math;

/**  
 * @ClassName: FibonacciNumbers  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class FibonacciNumbers {

    public final static int[] FIBS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,
        6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578,
        5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733,
        1134903170, 1836311903};

    public static void main(String[] args) {
        long[] dp = new long[2];
        dp[0] = 1;
        dp[1] = 1;
        System.out.print(1 + ",");
        System.out.print(1 + ",");
        int i = 1;
        while (true) {
            i ^= 1;
            dp[i] = dp[0] + dp[1];
            if (dp[i] > Integer.MAX_VALUE) {
                break;
            }
            System.out.print(dp[i] + ",");
        }

    }

}
