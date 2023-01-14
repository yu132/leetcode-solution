package old._0800_0899;

/**  
 * @ClassName: _848  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _848 {

    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            shifts[shifts.length - 1] %= 26;
            for (int i = shifts.length - 2; i >= 0; --i) {
                shifts[i] = (shifts[i] % 26 + shifts[i + 1]) % 26;
            }
            char[] arr = S.toCharArray();

            for (int i = 0; i < arr.length; ++i) {
                arr[i] = (char)('a' + (arr[i] - 'a' + shifts[i]) % 26);
            }

            return String.valueOf(arr);
        }
    }

}
