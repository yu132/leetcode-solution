/**
 * @Title: _667.java
 *
 * @Package _0600_0699
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月29日
 *
 */
package _0600_0699;

/**
 * @ClassName: _667
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月29日
 * 
 */
public class _667 {

    class Solution {
        public int[] constructArray(int n, int k) {

            int[]   ans  = new int[n];

            boolean asc  = false;

            int     from = -1, index = 0;

            for (int i = 1, j = n;; ++i, --j, k -= 2) {
                if (k == 0) {
                    asc  = false;
                    from = j;
                    break;
                } else if (k == 1) {
                    asc  = true;
                    from = i;
                    break;
                } else {// k>=2
                    ans[index++] = i;
                    ans[index++] = j;
                }
            }

            while (index != n) {
                if (asc) {
                    ans[index++] = from++;
                } else {
                    ans[index++] = from--;
                }
            }

            return ans;
        }
    }

}
