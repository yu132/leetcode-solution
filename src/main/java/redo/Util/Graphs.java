package redo.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 余定邦
 * @ClassName: Grapg
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月6日
 */
class Graphs {

    //带距离的无向图
    List<Road>[] toAdjacencyWithDistance(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Road>[] adjacency = new ArrayList[n];

        for (int i = 0; i < adjacency.length; ++i) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjacency[edge[0]].add(new Road(edge[1], edge[2]));
            adjacency[edge[1]].add(new Road(edge[0], edge[2]));
        }

        return adjacency;
    }

    static class Road {
        int next;
        long distance;

        public Road(int next, long distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    // 有向图
    List<Integer>[] toOrderlyAdjacency(int n, int[][] edges) {
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
    List<Integer>[] toAdjacency(int n, int[][] edges) {
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

    int[] countEnterDegree(List<Integer>[] graph) {
        int[] ed = new int[graph.length];
        for (int i = 0; i < ed.length; ++i) {
            for (int child : graph[i]) {
                ++ed[child];
            }
        }
        return ed;
    }

    // 有向图
    int[][] toOrderlyAdjacencyArray(int n, int[][] edges, int maxLen) {
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
    int[][] toAdjacencyArray(int n, int[][] edges, int maxLen) {
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
    List<Integer>[] toAdjacency(int n, int[] parents) {
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

    /**
     * 寻找两点之间是否有路径
     *
     * @param adjacency
     * @param from
     * @param to
     * @param n
     * @return
     */
    boolean findPath(List<Integer>[] adjacency, int from, int to, int n) {
        boolean[] visited = new boolean[n];

        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(from);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            if (node == to) {
                return true;
            }
            queue.addAll(adjacency[node]);
        }

        return false;
    }


    int furthestNode(int node, int n, List<Integer>[] graph) {
        return furthestNodeHelper(node, 0, graph, new boolean[n])[0];
    }

    int[] furthestNodeHelper(int node, int level, List<Integer>[] graph,
                             boolean[] visited) {
        if (visited[node]) {
            return new int[]{-1, 0};
        }
        visited[node] = true;
        int[] maxDis = {node, level};
        for (int child : graph[node]) {
            int[] ret = furthestNodeHelper(child, level + 1, graph, visited);
            if (ret[1] > maxDis[1]) {
                maxDis = ret;
            }
        }
        return maxDis;
    }


}
