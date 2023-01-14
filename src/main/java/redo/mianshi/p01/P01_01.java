package redo.mianshi.p01;

/**  
 * @ClassName: P01_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P01_01 {

    static//

    class Solution {
        public boolean isUnique(String astr) {
            BM bm = new BM(128);
            for (char ch : astr.toCharArray()) {
                if (bm.get(ch) == 1) {
                    return false;
                }
                bm.set(ch, 1);
            }
            return true;
        }

        static class BM {
            int[] bits;

            public BM(int len) {
                super();
                this.bits = new int[(len - 1) / 32 + 1];
            }

            public void set(int index, int bit) {
                int i1 = index / 32, i2 = index % 32;
                if (bit == 1) {
                    bits[i1] |= 1 << i2;
                } else {
                    bits[i1] &= ~(1 << i2);
                }
            }

            public int get(int index) {
                int i1 = index / 32, i2 = index % 32;
                return (bits[i1] & (1 << i2)) >> i2;
            }
        }
    }



    // class Solution {
    // public boolean isUnique(String astr) {
    // boolean[] shown = new boolean[128];
    // for (char ch : astr.toCharArray()) {
    // if (shown[ch]) {
    // return false;
    // }
    // shown[ch] = true;
    // }
    // return true;
    // }
    // }

}
