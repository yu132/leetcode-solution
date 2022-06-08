package timetest.comparator;

import org.openjdk.jmh.annotations.*;
import utils.RandomUtil;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class A {

    int[] server = RandomUtil.randomArr(200000, 1, 200000);
    int[] task = RandomUtil.randomArr(200000, 1, 200000);

    @Benchmark
    public void test1() {
        new SolutionA().assignTasks(server, task);
    }

    @Benchmark
    public void test2() {
        new SolutionB().assignTasks(server, task);
    }

    class SolutionA {
        public int[] assignTasks(int[] servers, int[] tasks) {
            PriorityQueue<Server> serverPq = new PriorityQueue<>(servers.length,
                    Comparator.comparing(Server::getWeight).thenComparing(Server::getIndex));
            for (int i = 0; i < servers.length; ++i) {
                serverPq.offer(new Server(servers[i], i));
            }
            PriorityQueue<Operation> ops = new PriorityQueue<>(tasks.length,
                    Comparator.comparing(Operation::getEndTime).thenComparing(op -> op.server.weight)
                            .thenComparing(op -> op.server.index));
            Queue<Task> tasksQueue = new LinkedList<>();
            int[] ans = new int[tasks.length];
            for (int i = 0; i < tasks.length; ++i) {
                while (!ops.isEmpty() && ops.peek().endTime == i) {
                    Server server = ops.poll().server;
                    serverPq.offer(server);
                }
                while (!tasksQueue.isEmpty() && !serverPq.isEmpty()) {
                    Task task = tasksQueue.poll();
                    Server server = serverPq.poll();
                    ops.offer(new Operation(i + task.costTime, server));
                    ans[task.index] = server.index;
                }
                if (!tasksQueue.isEmpty() || serverPq.isEmpty()) {
                    tasksQueue.offer(new Task(tasks[i], i));
                } else {
                    Server server = serverPq.poll();
                    ops.offer(new Operation(i + tasks[i], server));
                    ans[i] = server.index;
                }
            }
            while (!tasksQueue.isEmpty()) {
                Task task = tasksQueue.poll();
                Operation op = ops.poll();
                ops.offer(new Operation(op.endTime + task.costTime, op.server));
                ans[task.index] = op.server.index;
            }

            return ans;
        }

        class Task {
            int costTime;
            int index;

            public Task(int costTime, int index) {
                this.costTime = costTime;
                this.index = index;
            }
        }

        class Server {
            int weight;
            int index;

            public int getWeight() {
                return weight;
            }

            public int getIndex() {
                return index;
            }

            public Server(int weight, int index) {
                this.weight = weight;
                this.index = index;
            }

        }

        class Operation {
            int endTime;
            Server server;

            public int getEndTime() {
                return endTime;
            }

            public Operation(int endTime, Server server) {
                this.endTime = endTime;
                this.server = server;
            }
        }
    }

    class SolutionB {
        public int[] assignTasks(int[] servers, int[] tasks) {
            PriorityQueue<Server> serverPq = new PriorityQueue<>(servers.length,
                    (s1, s2) -> {
                        if (s1.weight == s2.weight) {
                            return Integer.compare(s1.index, s2.index);
                        }
                        return Integer.compare(s1.weight, s2.weight);
                    });
            for (int i = 0; i < servers.length; ++i) {
                serverPq.offer(new Server(servers[i], i));
            }
            PriorityQueue<Operation> ops = new PriorityQueue<>(tasks.length,
                    (op1, op2) -> {
                        if (op1.endTime != op2.endTime) {
                            return Integer.compare(op1.endTime, op2.endTime);
                        }
                        if (op1.server.weight != op2.server.weight) {
                            return Integer.compare(op1.server.weight, op2.server.weight);
                        }
                        return Integer.compare(op1.server.index, op2.server.index);
                    });
            Queue<Task> tasksQueue = new LinkedList<>();
            int[] ans = new int[tasks.length];
            for (int i = 0; i < tasks.length; ++i) {
                while (!ops.isEmpty() && ops.peek().endTime == i) {
                    Server server = ops.poll().server;
                    serverPq.offer(server);
                }
                while (!tasksQueue.isEmpty() && !serverPq.isEmpty()) {
                    Task task = tasksQueue.poll();
                    Server server = serverPq.poll();
                    ops.offer(new Operation(i + task.costTime, server));
                    ans[task.index] = server.index;
                }
                if (!tasksQueue.isEmpty() || serverPq.isEmpty()) {
                    tasksQueue.offer(new Task(tasks[i], i));
                } else {
                    Server server = serverPq.poll();
                    ops.offer(new Operation(i + tasks[i], server));
                    ans[i] = server.index;
                }
            }
            while (!tasksQueue.isEmpty()) {
                Task task = tasksQueue.poll();
                Operation op = ops.poll();
                ops.offer(new Operation(op.endTime + task.costTime, op.server));
                ans[task.index] = op.server.index;
            }

            return ans;
        }

        class Task {
            int costTime;
            int index;

            public Task(int costTime, int index) {
                this.costTime = costTime;
                this.index = index;
            }
        }

        class Server {
            int weight;
            int index;

            public int getWeight() {
                return weight;
            }

            public int getIndex() {
                return index;
            }

            public Server(int weight, int index) {
                this.weight = weight;
                this.index = index;
            }

        }

        class Operation {
            int endTime;
            Server server;

            public int getEndTime() {
                return endTime;
            }

            public Operation(int endTime, Server server) {
                this.endTime = endTime;
                this.server = server;
            }
        }
    }

}
