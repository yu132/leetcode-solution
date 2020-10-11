package _0700_0799;

/**  
 * @ClassName: _755  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _755 {

    class Solution {
        public int[] pourWater(int[] heights, int V, int K) {
            while (V-- != 0) {
                int low = K;
                for (int i = K; i >= 1; --i) {
                    if (heights[i] > heights[i - 1]) {
                        low = i - 1;
                        continue;
                    } else if (heights[i] == heights[i - 1]) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (heights[low] < heights[K]) {
                    ++heights[low];
                    continue;
                }
                for (int i = K; i < heights.length - 1; ++i) {
                    if (heights[i] > heights[i + 1]) {
                        low = i + 1;
                        continue;
                    } else if (heights[i] == heights[i + 1]) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (heights[low] < heights[K]) {
                    ++heights[low];
                    continue;
                }
                ++heights[K];
            }
            return heights;
        }
    }

}
