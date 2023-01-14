package old._0700_0799;

/**  
 * @ClassName: _800  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月29日  
 *  
 */
public class _800 {

    class Solution {
        public String similarRGB(String color) {
            return "#" + helper(color.substring(1, 3)) + helper(color.substring(3, 5)) + helper(color.substring(5, 7));
        }

        public String helper(String str) {
            int    high, low, now;
            String h, l;
            if (str.charAt(0) == str.charAt(1)) {
                return str;
            } else if (str.charAt(0) < str.charAt(1)) {

                char c = str.charAt(0) != '9' ? (char)(str.charAt(0) + 1) : 'a';

                h    = "" + c + c;
                l    = "" + str.charAt(0) + str.charAt(0);
                high = Integer.parseInt(h, 16);
                low  = Integer.parseInt(l, 16);
            } else {

                char c = str.charAt(0) != 'a' ? (char)(str.charAt(0) - 1) : '9';

                h    = "" + str.charAt(0) + str.charAt(0);
                l    = "" + c + c;
                high = Integer.parseInt(h, 16);
                low  = Integer.parseInt(l, 16);
            }
            now = Integer.parseInt(str, 16);
            if (high - now > now - low) {
                return l;
            } else {
                return h;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _800().new Solution().similarRGB("#09f166"));
    }

}
