package redo.offer2.p10;

/**  
 * @ClassName: P10_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_10 {

    static//

    class StreamRank {

        BitIndexTree bit = new BitIndexTree(50001);

        public StreamRank() {}

        public void track(int x) {
            bit.add(x, 1);
        }

        public int getRankOfNumber(int x) {
            return bit.get(x + 1);
        }

        static class BitIndexTree {
            int[] c;

            public BitIndexTree(int len) {
                super();
                this.c = new int[len + 1];
            }

            public void add(int index, int val) {
                for (int i = index + 1; i < c.length; i += i & -i) {
                    c[i] += val;
                }
            }

            public int get(int index) {
                int sum = 0;
                for (int i = index; i > 0; i -= i & -i) {
                    sum += c[i];
                }
                return sum;
            }

        }
    }

}
