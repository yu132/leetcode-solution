package old._0700_0799;

/**  
 * @ClassName: _779  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月24日  
 *  
 */
public class _779 {

    class Solution {
        public int kthGrammar(int N, int K) {
            if (K == 1) {
                return 0;
            }
            int val = toUpper2N(K);
            return kthGrammar(N, K - val / 2) ^ 1;
        }

        private int toUpper2N(int num) {

            int value = num - 1;

            value |= (value >>> 1);
            value |= (value >>> 2);
            value |= (value >>> 4);
            value |= (value >>> 8);
            value |= (value >>> 16);
            value++;

            if (value < 0)// 0x80000000 -> Integer.MIN_VALUE
                value >>>= 1;// 0x40000000 -> 2^30

            return value;
        }
    }

}
