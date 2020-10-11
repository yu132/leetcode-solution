package _0200_0299;

/**  
 * @ClassName: _299  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _299 {

    class Solution {
        public String getHint(String secret, String guess) {
            int[] c1   = new int[10];
            int[] c2   = new int[10];

            int   same = 0;

            for (int i = 0; i < secret.length(); ++i) {
                ++c1[secret.charAt(i) - '0'];
                ++c2[guess.charAt(i) - '0'];
                if (secret.charAt(i) == guess.charAt(i)) {
                    ++same;
                }
            }
            int count = 0;
            for (int i = 0; i < 10; ++i) {
                count += Math.min(c1[i], c2[i]);
            }

            return same + "A" + (count - same) + "B";
        }
    }

}
