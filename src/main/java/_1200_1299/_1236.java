package _1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**  
 * @ClassName: _1236  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _1236 {

    interface HtmlParser {
        public List<String> getUrls(String url);
    }

    class Solution {
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {

            Set<String>        visited = new HashSet<>();

            List<String>       ans     = new ArrayList<>();

            LinkedList<String> queue   = new LinkedList<>();
            queue.addLast(startUrl);

            while (!queue.isEmpty()) {
                String url = queue.removeFirst();
                if (visited.contains(url)) {
                    continue;
                }
                visited.add(url);
                if (!smaeDomain(url, startUrl)) {
                    continue;
                }
                ans.add(url);
                queue.addAll(htmlParser.getUrls(url));
            }

            return ans;
        }

        private boolean smaeDomain(String url1, String url2) {
            return getDomain(url1).equals(getDomain(url2));
        }

        private String getDomain(String url) {
            String temp  = url.substring(7);
            int    index = temp.indexOf('/');
            return index == -1 ? temp : temp.substring(0, index);
        }
    }

    public static void main(String[] args) {
        new _1236().new Solution().crawl("http://news.yahoo.com/news/topics/", new HtmlParser() {

            @Override
            public List<String> getUrls(String url) {
                switch (url) {
                    case "http://news.yahoo.com/news/topics/":
                        return Arrays.asList("http://news.yahoo.com", "http://news.yahoo.com/news");
                    case "http://news.google.com":
                        return Arrays.asList("http://news.yahoo.com/news", "http://news.yahoo.com/news/topics/");
                    case "http://news.yahoo.com":
                        return Arrays.asList("http://news.yahoo.com/us");
                    default:
                        return Collections.emptyList();
                }
            }
        });
    }
}
