package redo.offer2.p05;

/**  
 * @ClassName: P05_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P05_08 {

    static//

    class Solution {
        public int[] drawLine(int length, int w, int x1, int x2, int y) {
            BitMap map = new BitMap(length);
            for (int x = x1; x <= x2; ++x) {
                map.set(culIndex(w, x, y));
            }
            int[] ans = map.map;
            for (int i = 0; i < ans.length; ++i) {
                ans[i] = Integer.reverse(ans[i]);
            }
            return ans;
        }

        int culIndex(int w, int x, int y) {
            return y * w + x;
        }

        static class BitMap {
            int[] map;

            public BitMap(int len) {
                super();
                this.map = new int[len];
            }

            public void set(int index) {
                int index1 = index / 32, index2 = index % 32;
                map[index1] |= 1 << index2;
            }

        }
    }

}
