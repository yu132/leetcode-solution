package _0600_0699;

/**  
 * @ClassName: _604  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _604 {

    class StringIterator {

        private String str;
        private char nowCh;
        private int times = 0;
        private int index = 0;

        public StringIterator(String compressedString) {
            str = compressedString;
        }

        public char next() {
            if (times == 0) {
                if (index == str.length()) {
                    return ' ';
                }
                nowCh = str.charAt(index++);
                while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                    times *= 10;
                    times += str.charAt(index++) - '0';
                }
            }
            --times;
            return nowCh;
        }

        public boolean hasNext() {
            return times != 0 || index != str.length();
        }
    }

}
