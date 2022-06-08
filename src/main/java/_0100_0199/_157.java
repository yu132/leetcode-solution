package _0100_0199;

/**  
 * @ClassName: _157  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _157 {

    class Reader4 {
        int read4(char[] buf) {
            return 0;
        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] temp  = new char[4];
            int    index = 0;
            while (true) {
                int a = read4(temp);
                int b = Math.min(a, n);
                n -= a;
                System.arraycopy(temp, 0, buf, index, b);
                index += b;
                if (b < 4) {
                    break;
                }
            }
            return index;
        }
    }

}
