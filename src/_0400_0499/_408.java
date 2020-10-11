package _0400_0499;

/**  
 * @ClassName: _408  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _408 {

    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int index = 0, index4abbr = 0, num = 0;
            while (index < word.length() && index4abbr < abbr.length()) {
                while (index4abbr < abbr.length() && abbr.charAt(index4abbr) >= '0' && abbr.charAt(index4abbr) <= '9') {
                    if (num == 0 && abbr.charAt(index4abbr) - '0' == 0) {
                        return false;
                    }
                    num *= 10;
                    num += abbr.charAt(index4abbr++) - '0';
                }
                if (num != 0) {
                    index += num;
                    num    = 0;
                } else {
                    if (word.charAt(index) == abbr.charAt(index4abbr)) {
                        ++index;
                        ++index4abbr;
                    } else {
                        return false;
                    }
                }
            }
            return index == word.length() && index4abbr == abbr.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _408().new Solution().validWordAbbreviation("internationalization", "i18n"));
    }
}
