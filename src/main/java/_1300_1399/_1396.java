package _1300_1399;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: _1396  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _1396 {

    class UndergroundSystem {

        Map<String, long[]> map = new HashMap<>();

        Map<Integer, Object[]> in = new HashMap<>();

        public UndergroundSystem() {}

        public void checkIn(int id, String stationName, int t) {
            in.put(id, new Object[] {stationName, t});
        }

        public void checkOut(int id, String stationName, int t) {
            Object[] ci  = in.get(id);
            long[]   avg = map.computeIfAbsent(ci[0] + " " + stationName, (x) -> new long[2]);
            avg[0] += t - (Integer)ci[1];
            ++avg[1];
        }

        public double getAverageTime(String startStation, String endStation) {
            long[] temp = map.get(startStation + " " + endStation);
            return (double)temp[0] / temp[1];
        }
    }

}
