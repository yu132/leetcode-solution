package redo.Util;

/**  
 * @ClassName: Chars  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class Chars {

    public int[] countLowercaseLetters(String str) {
        int[] chs = new int[26];
        for (char ch : str.toCharArray()) {
            ++chs[ch - 'a'];
        }
        return chs;
    }

}
