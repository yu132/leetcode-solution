package redo.Util;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Graphs {

    // 有向图
    public List<Integer>[] toOrderlyAdjacency(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacency = new ArrayList[n];

        for (int i = 0; i < adjacency.length; ++i) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjacency[edge[0]].add(edge[1]);
        }

        return adjacency;
    }

    // 无向图
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

    public int[] countEnterDegree(List<Integer>[] graph) {
        int[] ed = new int[graph.length];
        for (int i = 0; i < ed.length; ++i) {
            for (int child : graph[i]) {
                ++ed[child];
            }
        }
        return ed;
    }

    // 有向图
    public int[][] toOrderlyAdjacencyArray(int n, int[][] edges, int maxLen) {
        int[][] distances = new int[n][n];
        for (int[] arr : distances) {
            Arrays.fill(arr, maxLen);
        }
        for (int[] edge : edges) {
            distances[edge[0]][edge[1]] = edge[2];
        }
        return distances;
    }

    // 无向图
    public int[][] toAdjacencyArray(int n, int[][] edges, int maxLen) {
        int[][] distances = new int[n][n];
        for (int[] arr : distances) {
            Arrays.fill(arr, maxLen);
        }
        for (int[] edge : edges) {
            distances[edge[0]][edge[1]] = edge[2];
            distances[edge[1]][edge[0]] = edge[2];
        }
        return distances;
    }

    // 父节点表示法的树结构
    public List<Integer>[] toAdjacency(int n, int[] parents) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacency = new ArrayList[n];

        for (int i = 0; i < adjacency.length; ++i) {
            adjacency[i] = new ArrayList<>();
        }

        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == -1) {// 根节点的父节点需要表示为-1，不是-1需要修改
                continue;
            }
            adjacency[parents[i]].add(i);
        }

        return adjacency;
    }



}
