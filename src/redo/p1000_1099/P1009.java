package redo.p1000_1099;

/**  
 * @ClassName: P1009  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P1009 {

    class Solution {
        public int bitwiseComplement(int N) {
            if (N == 0) {
                return 1;
            }
            return ~N & getMask(N);
        }

        public int getMask(int num) {
            num |= num >>> 1;
            num |= num >>> 2;
            num |= num >>> 4;
            num |= num >>> 8;
            num |= num >>> 16;
            return num;
        }
    }

}
