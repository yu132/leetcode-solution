package _1100_1199;

/**  
 * @ClassName: _1119  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1119 {

    class Solution {
        public String removeVowels(String S) {

            StringBuilder sb = new StringBuilder(S.length());

            for (char each : S.toCharArray()) {
                if (each == 'a' || each == 'e' || each == 'i' || each == 'o' || each == 'u') {
                    continue;
                }
                sb.append(each);
            }

            return sb.toString();
        }
    }

}
