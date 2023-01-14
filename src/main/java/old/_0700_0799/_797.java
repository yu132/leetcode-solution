/**
 * @Title: _797.java
 *
 * @Package old._0700_0799
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年2月1日
 *
 */
package old._0700_0799;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _797  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月1日  
 *  
 */
public class _797 {

    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        private List<Integer> nowPath;

        private int nowIndex;

        private int[][] graph;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            nowIndex   = 0;
            nowPath    = new ArrayList<>(graph.length);
            this.graph = graph;
            helper();
            return ans;
        }

        public void helper() {

            nowPath.add(nowIndex);

            if (nowIndex == graph.length - 1) {// 到达目的地
                ans.add(new ArrayList<>(nowPath));
                return;
            }

            int temp = nowIndex;
            for (int i = 0; i < graph[temp].length; ++i) {
                nowIndex = graph[temp][i];
                helper();
                nowPath.remove(nowPath.size() - 1);
            }

        }
    }

}
