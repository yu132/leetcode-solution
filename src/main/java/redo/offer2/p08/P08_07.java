package redo.offer2.p08;

/**  
 * @ClassName: P08_p7  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_07 {

    class Solution {

        int i;

        public String[] permutation(String S) {
            int n = S.length();
            String[] ans = new String[len(n)];
            i = 0;
            backtrack(0, S.toCharArray(), ans);
            return ans;
        }

        void backtrack(int index, char[] chs, String[] ans) {
            if (index == chs.length) {
                ans[i++] = String.valueOf(chs);
                return;
            }

            for (int i = index; i < chs.length; ++i) {
                char temp = chs[i];
                chs[i] = chs[index];
                chs[index] = temp;
                backtrack(index + 1, chs, ans);
                chs[index] = chs[i];
                chs[i] = temp;
            }
        }

        int len(int n) {
            int ans = 1;
            while (n != 1) {
                ans *= n--;
            }
            return ans;
        }
    }

}
