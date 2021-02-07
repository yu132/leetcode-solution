package redo.offer;

/**  
 * @ClassName: P58_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P58_2 {

    class Solution {
        public String reverseLeftWords(String s, int n) {
            n %= s.length();
            char[] ch = s.toCharArray();
            reverse(ch, 0, n);
            reverse(ch, n, ch.length);
            reverse(ch, 0, ch.length);
            return String.valueOf(ch);
        }

        void reverse(char[] ch, int start, int end) {
            --end;
            for (; start < end; ++start, --end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
            }
        }
    }

}
