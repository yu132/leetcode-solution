package _0800_0899;

/**  
 * @ClassName: _845  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _845 {

    class Solution {
        public int longestMountain(int[] A) {
            int     up         = 0, lenNow = 0, max = 0;
            boolean isMountain = false;
            for (int i = 1; i < A.length; ++i) {
                if (A[i] == A[i - 1]) {
                    if (up == -1 && isMountain) {
                        max = Math.max(max, lenNow);
                    }
                    up         = 0;
                    isMountain = false;
                } else if (A[i] > A[i - 1]) {
                    if (up == 1) {
                        ++lenNow;
                    } else if (up == 0) {
                        up         = 1;
                        lenNow     = 2;
                        isMountain = true;
                    } else {
                        if (isMountain) {
                            max = Math.max(max, lenNow);
                        }
                        up         = 1;
                        lenNow     = 2;
                        isMountain = true;
                    }
                } else {
                    if (up == 1) {
                        up = -1;
                        ++lenNow;
                    } else if (up == 0) {
                        up = -1;
                    } else if (up == -1) {
                        ++lenNow;
                    }
                }
            }
            if (up == -1 && isMountain) {
                max = Math.max(max, lenNow);
            }
            return max;
        }
    }

}
