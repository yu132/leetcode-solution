package redo.testUtil;

/**  
 * @ClassName: Arrs  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class Arrs {

    public static int[][] build2D(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = Splits.split(str);
        int[][] ans = new int[sp.length][];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = build(sp[i]);
        }
        return ans;
    }

    public static int[] build(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = str.split(",");
        int[] ans = new int[sp.length];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = Integer.valueOf(sp[i]);
        }
        return ans;
    }

}
