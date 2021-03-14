package redo.p0200_0299;

/**  
 * @ClassName: P299  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P299 {

    class Solution {
        public String getHint(String secret, String guess) {
            int[] countS = new int[10], countG = new int[10];

            int ex = 0;

            for (int i = 0; i < secret.length(); ++i) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    ++ex;
                } else {
                    ++countS[secret.charAt(i) - '0'];
                    ++countG[guess.charAt(i) - '0'];
                }
            }

            int c = 0;

            for (int i = 0; i < 10; ++i) {
                c += Math.min(countS[i], countG[i]);
            }

            return ex + "A" + c + "B";
        }
    }

}
