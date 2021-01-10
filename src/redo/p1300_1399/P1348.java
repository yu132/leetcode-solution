package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**  
 * @ClassName: P1348  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1348 {

    class TweetCounts {

        Map<String, TreeSet<Integer>> mapping = new HashMap<>();

        public TweetCounts() {}

        public void recordTweet(String tweetName, int time) {
            mapping.computeIfAbsent(tweetName, (x) -> new TreeSet<>()).add(time);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            TreeSet<Integer> set = mapping.get(tweetName);
            if (set == null) {
                return Collections.emptyList();
            }
            int delta = delta(freq);
            List<Integer> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>(set.subSet(startTime, endTime + 1));
            for (int start = startTime, end = startTime + delta - 1, i = 0; start <= endTime;
                start += delta, end += delta) {
                int count = 0;
                while (i < list.size() && list.get(i) <= end) {
                    ++i;
                    ++count;
                }
                ans.add(count);
            }
            return ans;
        }

        int delta(String freq) {
            switch (freq) {
                case "minute":
                    return 60;
                case "hour":
                    return 60 * 60;
                case "day":
                    return 60 * 60 * 24;
            }
            throw new RuntimeException("Illegal freq");
        }
    }


}
