package redo.testUtil;

import java.util.List;

import redo.Util.Lists;

/**  
 * @ClassName: StringList  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class StringList {

    public static List<List<String>> build2DList(String str) {
        return Lists.copy2D(build2D(str));
    }

    public static String[][] build2D(String str) {
        str = str.trim().substring(1, str.length() - 1);
        String[] sp = Splits.split(str);
        String[][] ans = new String[sp.length][];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = build(sp[i]);
        }
        return ans;
    }

    public static String[] build(String str) {
        str = str.trim().substring(1, str.length() - 1);
        String[] sp = str.split(",");
        String[] ans = new String[sp.length];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = sp[i].substring(1, sp[i].length() - 1);
        }
        return ans;
    }

}
