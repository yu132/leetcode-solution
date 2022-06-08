package _0200_0299;

/**  
 * @ClassName: _251  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月7日  
 *  
 */
public class _251 {

    class Vector2D {

        private int[][] data;
        private int row = 0, col = 0, next;

        private boolean hasNext;

        public Vector2D(int[][] v) {
            data = v;
            while (row != data.length && col == data[row].length) {
                col = 0;
                ++row;
            }
            if (row != data.length) {
                next    = data[row][col++];
                hasNext = true;
            } else {
                hasNext = false;
            }
        }

        public int next() {
            int temp = next;
            while (row != data.length && col == data[row].length) {
                col = 0;
                ++row;
            }
            if (row != data.length) {
                next    = data[row][col++];
                hasNext = true;
            } else {
                hasNext = false;
            }
            return temp;
        }

        public boolean hasNext() {
            return hasNext;
        }
    }

}
