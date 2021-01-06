package redo.Util;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: Grapg  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class Graph {

    public List<Integer>[] toAdjacency(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacency = new ArrayList[n];

        for (int i = 0; i < adjacency.length; ++i) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjacency[edge[0]].add(edge[1]);
            adjacency[edge[1]].add(edge[0]);
        }

        return adjacency;
    }



}
