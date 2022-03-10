package redo.p0300_0399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**  
 * @ClassName: P355  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P355 {

    static//

    class Twitter {

        Map<Integer, List<Data>> tweets = new HashMap<>();

        Map<Integer, Set<Integer>> follows = new HashMap<>();

        int time = 0;

        /** Initialize your data structure here. */
        public Twitter() {}

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            tweets.computeIfAbsent(userId, (x) -> new ArrayList<>())
                .add(new Data(time++, tweetId));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<List<Data>> followNow = new ArrayList<>();

            for (int followee : follows.getOrDefault(userId,
                Collections.emptySet())) {
                followNow.add(
                    tweets.getOrDefault(followee, Collections.emptyList()));
            }

            followNow.add(tweets.getOrDefault(userId, Collections.emptyList()));

            int n = followNow.size();

            int[] indexes = new int[n];

            PriorityQueue<DataAndIndex> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.d.time, a.d.time));

            for (int i = 0; i < n; ++i) {
                List<Data> list = followNow.get(i);
                indexes[i] = list.size() - 1;
                if (indexes[i] == -1) {
                    continue;
                }
                pq.offer(new DataAndIndex(list.get(indexes[i]--), i));
            }

            List<Integer> ans = new ArrayList<>();

            while (ans.size() < 10 && !pq.isEmpty()) {
                DataAndIndex di = pq.poll();
                ans.add(di.d.tweetId);
                if (indexes[di.index] == -1) {
                    continue;
                }
                List<Data> list = followNow.get(di.index);
                pq.offer(
                    new DataAndIndex(list.get(indexes[di.index]--), di.index));
            }

            return ans;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            follows.computeIfAbsent(followerId, (x) -> new HashSet<>())
                .add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            follows.computeIfAbsent(followerId, (x) -> new HashSet<>())
                .remove(followeeId);
        }

        static class Data {
            int time, tweetId;

            public Data(int time, int tweetId) {
                super();
                this.time = time;
                this.tweetId = tweetId;
            }

        }

        static class DataAndIndex {
            Data d;
            int index;

            public DataAndIndex(Data d, int index) {
                super();
                this.d = d;
                this.index = index;
            }
        }
    }

}
