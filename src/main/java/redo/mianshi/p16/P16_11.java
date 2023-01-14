package redo.mianshi.p16;

/**
 * @ClassName: P16_11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P16_11 {

    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (shorter == longer) {
                return new int[] {shorter * k};
            }
            int[] ans = new int[k + 1];
            for (int i = 0; i <= k; ++i) {
                ans[i] = shorter * (k - i) + longer * i;
            }
            return ans;
        }
    }

}
