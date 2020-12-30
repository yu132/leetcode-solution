package utils;

/**  
 * @ClassName: CharArrays  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class CharArrays {

    public static void reverse(char[] chs, int start, int end) {
        end = end - 1;
        while (start < end) {
            char ch = chs[start];
            chs[start] = chs[end];
            chs[end] = ch;
            ++start;
            --end;
        }
    }

}
