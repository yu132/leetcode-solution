package _0600_0699;

/**  
 * @ClassName: _678  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月18日  
 *  
 */
public class _678 {

    class Solution {
        public boolean checkValidString(String s) {
            int l = 0, h = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    ++l;
                    ++h;
                } else if (s.charAt(i) == '*') {
                    if (l > 0) {
                        --l;
                    }
                    ++h;
                } else {
                    if (l > 0) {
                        --l;
                    }
                    --h;
                }
                if (h < 0) {
                    return false;
                }
            }
            return l == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _678().new Solution().checkValidString(")(*)"));
    }
}
