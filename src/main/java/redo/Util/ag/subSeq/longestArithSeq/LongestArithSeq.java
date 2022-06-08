package redo.Util.ag.subSeq.longestArithSeq;

/**  
 * @ClassName: LongestArithSeq  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class LongestArithSeq {

    /*
     * 思路很简单，就是保存连接上的所有等差数列
     * 
     * 计算前一个和本数相差的值的前面接了多少个相同等差的数列长，然后加一即可
     */

    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][20001];
        int max = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int diff = A[i] - A[j] + 10000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max + 1;
    }

}
