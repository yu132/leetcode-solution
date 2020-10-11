package _1300_1399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**  
 * @ClassName: _1348  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _1348 {

    class TweetCounts {

        private HashMap<String, TreeMap<Integer, Integer>> map = new HashMap<>();

        private TreeMap<Integer, Integer> emptyTreeMap = new TreeMap<>();

        public final static int MIN = 60, HOUR = MIN * 60, DAY = HOUR * 24;

        public TweetCounts() {}

        public void recordTweet(String tweetName, int time) {
            TreeMap<Integer, Integer> counter = map.computeIfAbsent(tweetName, (x) -> new TreeMap<>());
            counter.put(time, counter.getOrDefault(time, 0) + 1);
        }

        public int feq(String feq) {
            switch (feq) {
                case "minute":
                    return MIN;
                case "hour":
                    return HOUR;
                case "day":
                    return DAY;
            }
            return -1;
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            TreeMap<Integer, Integer>   counter = map.getOrDefault(tweetName, emptyTreeMap);
            SortedMap<Integer, Integer> subMap  = counter.subMap(startTime, endTime + 1);

            int                         feq     = feq(freq);

            List<Integer>               ans     = new ArrayList<>();
            while (startTime <= endTime) {
                int sum = 0;
                for (int val : subMap.subMap(startTime, Math.min(startTime + feq, endTime + 1)).values()) {
                    sum += val;
                }
                ans.add(sum);
                startTime += feq;
            }

            return ans;
        }
    }

}
