package redo.testUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static List<List<String>> build2DsL(String str) {
        return StringList.build2DList(str);
    }

    public static List<List<Integer>> build2DL(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        if (str.equals("")) {
            return Collections.emptyList();
        }
        String[] sp = Splits.split(str);
        List<List<Integer>> ans = new ArrayList<>(sp.length);
        for (int i = 0; i < sp.length; ++i) {
            ans.add(buildL(sp[i]));
        }
        return ans;
    }

    public static List<Integer> buildL(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        if (str.equals("")) {
            return Collections.emptyList();
        }
        String[] sp = str.split(",");
        List<Integer> ans = new ArrayList<>(sp.length);
        for (int i = 0; i < sp.length; ++i) {
            ans.add(Integer.valueOf(sp[i]));
        }
        return ans;
    }

    public static int[][] build2D(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        if (str.equals("")) {
            return new int[0][];
        }
        String[] sp = Splits.split(str);
        int[][] ans = new int[sp.length][];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = build(sp[i]);
        }
        return ans;
    }

    public static double[][] build2Dd(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = Splits.split(str);
        double[][] ans = new double[sp.length][];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = buildDouble(sp[i]);
        }
        return ans;
    }

    public static double[] buildDouble(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = str.split(",");
        double[] ans = new double[sp.length];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = Double.valueOf(sp[i]);
        }
        return ans;
    }

    public static char[][] build2Dc(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = Splits.split(str);
        char[][] ans = new char[sp.length][];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = buildChar(sp[i]);
        }
        return ans;
    }

    private static char[] buildChar(String str) {
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = str.split(",");
        char[] ans = new char[sp.length];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = sp[i].charAt(1);
        }
        return ans;
    }

    public static int[] build(String str) {
        if (str.equals("[]")) {
            return new int[0];
        }
        str = str.substring(1, str.length() - 1).replaceAll("\\s", "");
        String[] sp = str.split(",");
        int[] ans = new int[sp.length];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = Integer.valueOf(sp[i]);
        }
        return ans;
    }

    public static <T> String toStrL(List<List<T>> list) {
        if (list.size() == 0) {
            return "[]";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < list.size() - 1; ++i) {
            buf.append(list.get(i) + ",");
        }
        buf.append(list.get(list.size() - 1) + "]");
        return buf.toString().replaceAll("\\s", "");
    }

    public static String toStr(List<int[]> list) {
        if (list.size() == 0) {
            return "[]";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < list.size() - 1; ++i) {
            buf.append(Arrays.toString(list.get(i)) + ",");
        }
        buf.append(Arrays.toString(list.get(list.size() - 1)) + "]");
        return buf.toString().replaceAll("\\s", "");
    }

    public static String todStr(List<double[]> list) {
        if (list.size() == 0) {
            return "[]";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < list.size() - 1; ++i) {
            buf.append(Arrays.toString(list.get(i)) + ",");
        }
        buf.append(Arrays.toString(list.get(list.size() - 1)) + "]");
        return buf.toString();
    }

    public static <T> String deepToStr(List<T[]> list) {
        if (list.size() == 0) {
            return "[]";
        }
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i = 0; i < list.size() - 1; ++i) {
            buf.append(Arrays.deepToString(list.get(i)) + ",");
        }
        buf.append(Arrays.deepToString(list.get(list.size() - 1)) + "]");
        return buf.toString().replaceAll("\\s", "");
    }

    public static String toStr(Object[] obj) {
        return Arrays.deepToString(obj).replaceAll("\\s", "");
    }

    public static <T> String toLStr(List<T> list) {
        return list.toString().replaceAll("\\s", "");
    }
}
