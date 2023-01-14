package old._0100_0199;

/**  
 * @ClassName: _159  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月16日  
 *  
 */
public class _159 {

    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            char[] now   = new char[2];
            int[]  index = new int[2], start = new int[2];

            int    max   = 0;

            for (int i = 0; i < s.length(); ++i) {

                if (s.charAt(i) == now[0]) {
                    index[0] = i;
                } else if (s.charAt(i) == now[1]) {
                    index[1] = i;
                } else {
                    if (now[0] == 0) {
                        now[0]   = s.charAt(i);
                        index[0] = start[0] = i;
                    } else if (now[1] == 0) {
                        now[1]   = s.charAt(i);
                        index[1] = start[1] = i;
                    } else if (index[0] < index[1]) {
                        max      = Math.max(max, i - Math.min(start[0], start[1]));
                        start[1] = index[0] + 1;
                        now[0]   = s.charAt(i);
                        index[0] = start[0] = i;
                    } else {
                        max      = Math.max(max, i - Math.min(start[0], start[1]));
                        start[0] = index[1] + 1;
                        now[1]   = s.charAt(i);
                        index[1] = start[1] = i;
                    }
                }
            }
            max = Math.max(max, s.length() - Math.min(start[0], start[1]));

            return max;
        }
    }

    public static void main(String[] args) {
        new _159().new Solution().lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
