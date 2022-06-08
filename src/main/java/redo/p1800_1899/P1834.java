package redo.p1800_1899;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1834 {

    class Solution {
        public int[] getOrder(int[][] tasks) {
            Task[] arr = new Task[tasks.length];
            Arrays.setAll(arr, x -> new Task(x, tasks[x][0], tasks[x][1]));
            Arrays.sort(arr, Comparator.comparingInt(Task::getEnqueueTime));

            PriorityQueue<Task> pq = new PriorityQueue<>();
            int time = -1;

            int index = 0, ansIndex = 0;
            int[] ans = new int[arr.length];
            while (index < arr.length || !pq.isEmpty()) {
                while (index < arr.length && arr[index].enqueueTime <= time) {
                    pq.offer(arr[index++]);
                }
                if (pq.isEmpty()) {
                    time = arr[index].enqueueTime;
                    continue;
                }
                Task top = pq.poll();
                ans[ansIndex++] = top.index;
                time += top.processingTime;
            }
            return ans;
        }

        class Task implements Comparable<Task> {
            int index, enqueueTime, processingTime;

            public int getEnqueueTime() {
                return enqueueTime;
            }

            public Task(int index, int enqueueTime, int processingTime) {
                this.index = index;
                this.enqueueTime = enqueueTime;
                this.processingTime = processingTime;
            }

            @Override
            public int compareTo(Task o) {
                if (processingTime != o.processingTime) {
                    return Integer.compare(processingTime, o.processingTime);
                }
                return Integer.compare(index, o.index);
            }
        }
    }

}
