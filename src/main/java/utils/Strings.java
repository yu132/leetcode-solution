package utils;

/**  
 * @ClassName: Strings  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class Strings {

    public static String repeat(String str, int num) {
        StringBuilder sb = new StringBuilder(str.length() * num);
        for (int i = 0; i < num; ++i) {
            sb.append(str);
        }
        return sb.toString();
    }

}
