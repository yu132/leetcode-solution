package old._1500_1599;

/**  
 * @ClassName: _1528  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月25日  
 *  
 */
public class _1528 {

    class Solution {
        public String restoreString(String s, int[] indices) {
            char[] chs = new char[s.length()];

            for (int i = 0; i < indices.length; ++i) {
                chs[indices[i]] = s.charAt(i);
            }

            return String.valueOf(chs);
        }
    }

}
