package redo.p0500_0599;

import java.util.concurrent.ThreadLocalRandom;

/**  
 * @ClassName: P528  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P528 {

    class Solution {

        ThreadLocalRandom r = ThreadLocalRandom.current();

        int[] w;

        public Solution(int[] w) {
            for (int i = 1; i < w.length; ++i) {
                w[i] += w[i - 1];
            }
            this.w = w;
        }

        public int pickIndex() {
            int val = r.nextInt(w[w.length - 1]);
            return upperBound(w, val);
        }

        int upperBound(int[] w, int val) {
            int low = 0, high = w.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (val < w[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }


}
