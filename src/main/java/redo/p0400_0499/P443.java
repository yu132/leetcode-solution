package redo.p0400_0499;

/**  
 * @ClassName: P443  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P443 {

    class Solution {
        public int compress(char[] chars) {
            if (chars.length == 0) {
                return 0;
            }

            char ch = chars[0];
            int count = 1;

            int indexToInsert = 0, indexToCheck = 1;

            for (; indexToCheck < chars.length; ++indexToCheck) {
                if (chars[indexToCheck] == ch) {
                    ++count;
                    continue;
                }

                chars[indexToInsert++] = ch;

                if (count != 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[indexToInsert++] = c;
                    }
                }

                ch = chars[indexToCheck];
                count = 1;
            }

            chars[indexToInsert++] = ch;

            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[indexToInsert++] = c;
                }
            }

            return indexToInsert;
        }
    }

}
