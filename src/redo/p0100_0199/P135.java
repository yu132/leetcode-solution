package redo.p0100_0199;

/**  
 * @ClassName: P135  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P135 {

    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;

            int lastTop = 1, dec = 0, pre = 1, ans = 1;
            for (int i = 1; i < n; ++i) {
                if (ratings[i] >= ratings[i - 1]) {
                    dec = 0;
                    if (ratings[i] == ratings[i - 1]) {
                        pre = 1;
                    } else {
                        ++pre;
                    }
                    ans += pre;
                    lastTop = pre;
                } else {
                    ++dec;
                    if (dec == lastTop) {
                        ++dec;
                    }
                    ans += dec;
                    pre = 1;
                }
            }
            return ans;
        }
    }

}
