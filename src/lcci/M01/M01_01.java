package lcci.M01;

/**  
 * @ClassName: M01_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月25日  
 *  
 */
public class M01_01 {

    class Solution {
        public boolean isUnique(String astr) {
            boolean[] flag = new boolean[26];
            for (int i = 0; i < astr.length(); ++i) {
                if (flag[astr.charAt(i) - 'a']) {
                    return false;
                } else {
                    flag[astr.charAt(i) - 'a'] = true;
                }
            }
            return true;
        }
    }

}
