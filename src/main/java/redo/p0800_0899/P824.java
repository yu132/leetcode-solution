package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P824  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P824 {

    class Solution {
        public String toGoatLatin(String S) {
            String[] words = S.split(" ");
            StringBuilder buf = new StringBuilder(S.length() * 4);
            for (int i = 0; i < words.length; ++i) {
                char start = Character.toLowerCase(words[i].charAt(0));
                if (start == 'a' || start == 'o' || start == 'e' || start == 'i' || start == 'u') {
                    buf.append(words[i]);
                } else {
                    buf.append(words[i].substring(1)).append(words[i].charAt(0));
                }
                buf.append("ma");
                for (int j = 0; j < i + 1; ++j) {
                    buf.append('a');
                }
                buf.append(' ');
            }
            return buf.substring(0, buf.length() - 1);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", s.toGoatLatin("I speak Goat Latin"));
        Assert.assertEquals(
            "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
            s.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        Assert.assertEquals(
            "Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa",
            s.toGoatLatin("Each word consists of lowercase and uppercase letters only"));

    }

}
