package redo.Util.ag.convexHull;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: GrahamScanUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class GrahamScanUtil {

    static class GrahamScan {

        FixedIntArrayStack stack;
        double[][] points;

        public void helper(double[][] points) {
            stack = new FixedIntArrayStack(points.length + 1);
            this.points = points;

            if (points.length <= 2) {
                return;
            }

            boolean allSameLine = true;
            for (int i = 2; i < points.length; ++i) {
                if (!sameLine(points[0], points[1], points[i])) {
                    allSameLine = false;
                    break;
                }
            }

            if (allSameLine) {
                return;
            }

            int leftDownIndex = findLeftDown(points);
            swap(0, leftDownIndex, points);
            Arrays.sort(points, 1, points.length, (o1, o2) -> {
                if (o1[1] == points[0][1] && o2[1] == points[0][1])// 与基准点水平
                    return o1[0] > o2[0] ? 1 : -1;
                if (o1[1] == points[0][1] || o2[1] == points[0][1])
                    return o1[1] == points[0][1] ? -1 : 1;

                if ((o1[0] - points[0][0]) * (o2[0] - points[0][0]) < 0)// 在基准点两侧
                    return o1[0] > o2[0] ? -1 : 1;

                double a1 = (o1[0] == points[0][0]) ? 0 : (o1[1] - points[0][1]) / (o1[0] - points[0][0]);
                double a2 = (o2[0] == points[0][0]) ? 0 : (o2[1] - points[0][1]) / (o2[0] - points[0][0]);

                if (a1 == 0 && a2 == 0)
                    return o1[1] > o2[1] ? -1 : 1;
                else if (a1 == 0 || a2 == 0)
                    return o1[0] > o2[0] ? -1 : 1;
                if (Double.compare(a1, a2) == 0) {
                    return o1[0] < o2[0] ? -1 : 1;
                }
                return Double.compare(a1, a2);
            });

            grahamScan(points);
        }

        private void grahamScan(double[][] points) {
            int n = points.length;
            for (int i = 0; i <= n; ++i) {
                while (stack.size() >= 2
                    && cross(points[stack.peek2()], points[stack.peek()], points[stack.peek2()], points[i % n]) < 0) {
                    stack.pop();
                }
                stack.push(i % n);
            }
            stack.pop();
        }

        private <T> void swap(int i, int j, T[] arr) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private int findLeftDown(double[][] points) {
            int leftDown = 0;
            for (int i = 1; i < points.length; ++i) {
                if (points[i][1] < points[leftDown][1]
                    || (points[i][1] == points[leftDown][1] && points[i][0] < points[leftDown][0])) {
                    leftDown = i;
                }
            }
            return leftDown;
        }

        private static boolean sameLine(double[] ds, double[] o1, double[] o2) {
            double x1 = o1[0], y1 = o1[1];
            double x2 = o2[0], y2 = o2[1];
            double x3 = ds[0], y3 = ds[1];

            return new Double(x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3).compareTo(new Double(0)) == 0;
        }

        public double cross(double[] p1, double[] p2, double[] p3, double[] p4) {
            return (p2[0] - p1[0]) * (p4[1] - p3[1]) - (p2[1] - p1[1]) * (p4[0] - p3[0]);
        }

        public int compPolarAngle(double[] base, double[] a, double[] b) {
            double temp = cross(base, a, base, b);
            if (temp == 0) {
                if (a[1] == b[1]) {
                    return Double.compare(a[0], b[0]);
                }
                return Double.compare(a[1], b[1]);
            }
            return temp > 0 ? -1 : 1;
        }

        static class FixedIntArrayStack {
            int index = 0, stack[];

            public FixedIntArrayStack(int len) {
                super();
                this.stack = new int[len];
            }

            public void push(int num) {
                stack[index++] = num;
            }

            public int pop() {
                return stack[--index];
            }

            public int peek() {
                return stack[index - 1];
            }

            public int peek2() {
                return stack[index - 2];
            }

            public boolean isEmpty() {
                return index == 0;
            }

            public int size() {
                return index;
            }
        }
    }

    @Test
    public void test() {
        GrahamScan gs = new GrahamScan();
        double[][] testcase = new double[16][2];
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 4; ++j) {
                testcase[(i - 1) * 4 + j - 1][0] = i;
                testcase[(i - 1) * 4 + j - 1][1] = j;
            }
        }
        gs.helper(testcase);
        for (int i = 0; i < gs.stack.size(); ++i) {
            System.out.println(Arrays.toString(gs.points[gs.stack.stack[i]]));
        }
    }

    @Test
    public void test2() {
        GrahamScan gs = new GrahamScan();
        double[][] testcase = {{0, 0}, {0, 1}, {0, 2}};
        gs.helper(testcase);
        System.out.println("t2");
        for (int i = 0; i < gs.stack.size(); ++i) {
            System.out.println(Arrays.toString(gs.points[gs.stack.stack[i]]));
        }
    }

}
