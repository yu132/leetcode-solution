package redo.p0300_0399;

/**  
 * @ClassName: P387  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P387 {

    class Solution {
        public int firstUniqChar(String s) {
            int first = 0, second = 0;
            char[] chs = s.toCharArray();
            for (char ch : chs) {
                if ((first & (1 << ch - '0')) == 0) {
                    first |= (1 << ch - '0');
                } else {
                    second |= (1 << ch - '0');
                }
            }
            for (int i = 0; i < s.length(); ++i) {
                if ((second & (1 << chs[i] - '0')) == 0) {
                    return i;
                }
            }
            return -1;
        }
    }

}
