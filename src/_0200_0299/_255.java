package _0200_0299;

/**  
 * @ClassName: _255  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月8日  
 *  
 */
public class _255 {

    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length);
        }

        public boolean helper(int[] arr, int f, int t) {
            if (f >= t - 1) {
                return true;
            }
            int     mid    = t;
            boolean hasMid = false;
            for (int i = f + 1; i < t; ++i) {
                if (arr[i] < arr[f]) {
                    if (hasMid) {
                        return false;
                    }
                } else {
                    if (!hasMid) {
                        hasMid = true;
                        mid    = i;
                    }
                }
            }
            return helper(arr, f + 1, mid) && helper(arr, mid, t);
        }
    }

    public static void main(String[] args) {
        new _255().new Solution().verifyPreorder(new int[] {2, 1});
    }
}
