package redo.Util.ag.convexHull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: Test  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class Ding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T > 0) {
            int len = sc.nextInt();
            sc.nextLine();

            String line = sc.nextLine();
            String[] words = line.split(" ");
            double[][] points = new double[len][2];
            double[] first = new double[] {Double.MAX_VALUE, Double.MAX_VALUE};
            for (int i = 0; i < len; i++) {
                double t1 = Double.parseDouble(words[i * 2]);
                double t2 = Double.parseDouble(words[i * 2 + 1]);
                points[i][0] = t1;
                points[i][1] = t2;
                if (points[i][1] < first[1]) {
                    first[0] = points[i][0];
                    first[1] = points[i][1];
                } else if (points[i][1] == first[1]) {
                    first[0] = Math.min(first[0], points[i][0]);
                }
            }

            List<double[]> ans = findConvexHull(points, first);

            if (ans.size() <= 2) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (double[] i : ans) {
                    if (isIntegerForDouble(i[0]))
                        sb.append((int)i[0]);
                    else
                        sb.append(i[0]);
                    sb.append(" ");
                    if (isIntegerForDouble(i[1]))
                        sb.append((int)i[1]);
                    else
                        sb.append(i[1]);

                    sb.append(", ");
                }
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
            }

            T--;
        }
    }

    public static List<double[]> findConvexHull(double[][] points, double[] first) {
        if (points.length <= 2)
            return new LinkedList<>();

        Arrays.sort(points, new Comparator<double[]>() {// 计算各个点相对于 P0 的幅角 α
            // ，按从小到大的顺序对各个点排序
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == first[1] && o2[1] == first[1])// 与基准点水平
                    return o1[0] > o2[0] ? 1 : -1;
                if (o1[1] == first[1] || o2[1] == first[1])
                    return o1[1] == first[1] ? -1 : 1;

                if ((o1[0] - first[0]) * (o2[0] - first[0]) < 0)// 在基准点两侧
                    return o1[0] > o2[0] ? -1 : 1;

                double a1 = o1[0] == first[0] ? 0 : (o1[1] - first[1]) / (o1[0] - first[0]);
                double a2 = o2[0] == first[0] ? 0 : (o2[1] - first[1]) / (o2[0] - first[0]);

                if (a1 == 0 && a2 == 0)
                    return o1[1] > o2[1] ? -1 : 1;
                else if (a1 == 0 || a2 == 0)
                    return o1[0] > o2[0] ? -1 : 1;
                if (new Double(a1).compareTo(new Double(a2)) == 0) {
                    return o1[0] < o2[0] ? -1 : 1;
                }
                return new Double(a1).compareTo(new Double(a2));
            }
        });


        if (points[0][0] == points[1][0]) {
            int i = 1;
            while (i < points.length && points[0][0] == points[i][0])
                i++;
            i--;

            int l = 1;
            while (l < i) {
                double[] temp = points[l];
                points[l] = points[i];
                points[i] = temp;
                i--;
                l++;
            }
        }

        Stack<double[]> st = new Stack<>();
        st.push(points[0]);
        st.push(points[1]);
        for (int i = 2; i <= points.length; i++) {
            int pos = i % points.length;
            if (onTheRight(points[pos], st.elementAt(st.size() - 2), st.elementAt(st.size() - 1))) {
                st.pop();
                i--;
            } else {
                st.add(points[pos]);
            }
        }
        st.pop();

        List<double[]> ans = new ArrayList<>(st.size());
        for (double[] i : st)
            ans.add(i);
        Collections.sort(ans, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (new Double(o1[0]).compareTo(new Double(o2[0])) == 0) {
                    return new Double(o1[1]).compareTo(new Double(o2[1]));
                }
                return new Double(o1[0]).compareTo(new Double(o2[0]));
            }
        });

        boolean Collinear = true;
        for (int i = 2; Collinear && i < points.length; i++) {
            if (!onTheLine(points[0], points[1], points[i]))
                Collinear = false;
        }
        if (Collinear)
            return new LinkedList<>();

        return ans;
    }

    private static boolean onTheRight(double[] ds, double[] o1, double[] o2) {
        double x1 = o1[0], y1 = o1[1];
        double x2 = o2[0], y2 = o2[1];
        double x3 = ds[0], y3 = ds[1];

        return x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3 < 0;
    }

    private static boolean onTheLine(double[] ds, double[] o1, double[] o2) {
        double x1 = o1[0], y1 = o1[1];
        double x2 = o2[0], y2 = o2[1];
        double x3 = ds[0], y3 = ds[1];

        return new Double(x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3).compareTo(new Double(0)) == 0;
    }

    public static boolean isIntegerForDouble(double obj) {
        double eps = 1e-10; // 精度范围
        return obj - Math.floor(obj) < eps;
    }

    @Test
    public void test() {
        // double[][] testcase = new double[16][2];
        // for (int i = 1; i <= 4; ++i) {
        // for (int j = 1; j <= 4; ++j) {
        // testcase[(i - 1) * 4 + j - 1][0] = i;
        // testcase[(i - 1) * 4 + j - 1][1] = j;
        // }
        // }
        double[][] testcase = {{0, 0}, {0, 1}, {0, 2}};
        System.out.println(Arrs.todStr(findConvexHull(testcase, new double[] {1, 1})));
    }

}
