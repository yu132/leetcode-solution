package redo.p1800_1899;

/**  
 * @ClassName: P1880  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1880 {

    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord,
            String targetWord) {
            int maxLen =
                Math.max(Math.max(firstWord.length(), secondWord.length()),
                    targetWord.length());

            int inc = 0;

            for (int i = 0; i < maxLen || inc != 0; ++i) {
                int num = get(firstWord, i) + get(secondWord, i) + inc;
                if (num % 10 != get(targetWord, i)) {
                    return false;
                }
                inc = num / 10;
            }

            return true;
        }

        public int get(String str, int index) {
            if (index >= str.length()) {
                return 0;
            }
            return str.charAt(str.length() - index - 1) - 'a';
        }
    }

}
