package redo.Util;

/**  
 * @ClassName: Strings  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class Strings {

    public String repeat(char ch, int times) {
        StringBuilder buf = new StringBuilder(times);
        for (int i = 0; i < times; ++i) {
            buf.append(ch);
        }
        return buf.toString();
    }

}
