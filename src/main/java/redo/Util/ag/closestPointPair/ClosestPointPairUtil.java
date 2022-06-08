package redo.Util.ag.closestPointPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: ClosestPointPairUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class ClosestPointPairUtil {

    static class ClosestPointPair {

        double closestDistance = Integer.MAX_VALUE;
        List<double[][]> closestPointPairs = new ArrayList<>();
        private Map<PointPair, Double> disMapping = new HashMap<>();

        public void closest(double[][] points) {
            Arrays.sort(points, (a, b) -> {
                if (a[0] == b[0]) {
                    return Double.compare(a[1], b[1]);
                }
                return Double.compare(a[0], b[0]);
            });
            closest(points, 0, points.length);
        }

        private double closest(double[][] points, int start, int end) {
            int len = end - start;
            if (len == 1) {
                return Integer.MAX_VALUE;
            } else if (len == 2) {
                return distance(points[start], points[start + 1]);
            }
            int mid = (start + end) >>> 1;
            double dis1 = closest(points, start, mid);
            double dis2 = closest(points, mid, end);
            double minDis = Math.min(dis1, dis2);

            List<double[]> candidate = new ArrayList<>(len);

            for (int i = start; i < end; ++i) {
                if (Math.abs(points[i][0] - points[mid][0]) <= minDis) {
                    candidate.add(points[i]);
                }
            }

            Collections.sort(candidate, (a, b) -> {
                if (a[1] == b[1]) {
                    return Double.compare(a[0], b[0]);
                }
                return Double.compare(a[1], b[1]);
            });

            for (int i = 0; i < candidate.size(); ++i) {
                for (int j = i + 1; j < 6 && j < candidate.size(); ++j) {
                    if (candidate.get(j)[1] - candidate.get(i)[1] > minDis) {
                        break;
                    }
                    double d = distance(candidate.get(j), candidate.get(i));
                    if (d < minDis) {
                        minDis = d;
                    }
                }
            }

            return minDis;
        }

        private double distance(double[] point1, double[] point2) {
            Double dd = null;
            PointPair pp = new PointPair(point1, point2);
            if ((dd = disMapping.get(pp)) != null) {
                return dd;
            }
            double d = Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
            if (d < closestDistance) {
                closestDistance = d;
                closestPointPairs.clear();
                closestPointPairs.add(new double[][] {point1, point2});
            } else if (d == closestDistance) {
                closestPointPairs.add(new double[][] {point1, point2});
            }
            disMapping.put(pp, d);
            return d;
        }

        static class PointPair {
            double[] point1;
            double[] point2;

            @Override
            public int hashCode() {
                return (Arrays.hashCode(point1) ^ Arrays.hashCode(point2)) * 31;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                PointPair other = (PointPair)obj;

                return (Arrays.equals(point1, other.point1) && Arrays.equals(point2, other.point2))
                    || (Arrays.equals(point1, other.point2) && Arrays.equals(point2, other.point1));
            }

            public PointPair(double[] point1, double[] point2) {
                super();
                this.point1 = point1;
                this.point2 = point2;
            }
        }
    }



    @Test
    public void test() {
        ClosestPointPair s = new ClosestPointPair();
        s.closest(Arrs.build2Dd("[[1,1],[2,2],[3,3],[4,4],[5,5],[1.5,1.5]]"));
        Assert.assertEquals("[[[1.5,1.5],[2.0,2.0]],[[1.5,1.5],[1.0,1.0]]]", Arrs.deepToStr(s.closestPointPairs));
    }

}
