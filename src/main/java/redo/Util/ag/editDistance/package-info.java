/**  
 * @ClassName: package-info  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
package redo.Util.ag.editDistance;

/*
 * 编辑距离是一个比较好想的dp的题
 * dp[i][j]=min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+same(i-1,j-1));
 * 
 * same(i-1,j-1)表示i-1和j-1处的字符是否相同，相同返回0，不同返回1
 * 
 * 不过我希望借这个题来说一说边界的问题
 * 
 * 有的时候返回dp[m][n]，有的时候返回dp[m-1][n-1]
 * 
 * 这是因为状态的种数不同而导致的，对于本题
 * 对于每种字符串，都有其长度种状态，为什么是0-m而不是1-m
 * 这是因为0表示本字符串为空，字符是允许为空的
 */
