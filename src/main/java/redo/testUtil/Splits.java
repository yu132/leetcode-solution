package redo.testUtil;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: Split  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class Splits {

    public static String[] split(String str) {
        str += ",";
        int left = 0, right = 0, start = 0;
        List<String> sp = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '[') {
                ++left;
            } else if (ch == ']') {
                ++right;
            } else if (ch == ',') {
                if (left == right) {
                    sp.add(str.substring(start, i));
                    start = i + 1;
                }
            }
        }
        return sp.toArray(new String[0]);
    }

}
