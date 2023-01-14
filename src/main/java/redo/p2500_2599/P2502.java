package redo.p2500_2599;

public class P2502 {


    class Allocator {

        int[] mem;

        public Allocator(int n) {
            mem = new int[n];
        }

        public int allocate(int size, int mID) {
            int start = -1, end = -1;
            for (int i = 0; i < mem.length; ++i) {
                if (start == -1) {
                    if (mem[i] == 0) {
                        start = i;
                    }
                } else {
                    if (i - start == size) {
                        end = i;
                        break;
                    }
                    if (mem[i] != 0) {
                        start = -1;
                    }
                }
            }
            if (start == -1) {
                return -1;
            }
            if (end == -1 && mem.length - start == size) {
                end = mem.length;
            }
            if (end == -1) {
                return -1;
            }
            for (int i = start; i < end; ++i) {
                mem[i] = mID;
            }
            return start;
        }

        public int free(int mID) {
            int count = 0;
            for (int i = 0; i < mem.length; ++i) {
                if (mem[i] == mID) {
                    ++count;
                    mem[i] = 0;
                }
            }
            return count;
        }
    }


//    class Allocator {
//
//        TreeMap<Integer, TreeMap<Integer, Node>> memoryManager = new TreeMap<>();
//
//        HashMap<Integer, Node> leftMap = new HashMap<>(), rightMap = new HashMap<>();
//        HashMap<Integer, List<Node>> idMap = new HashMap<>();
//
//
//        class Node {
//            int left;
//            int right;
//
//            boolean allocate = false;
//            int mid = 0;
//
//            void removeSelf() {
//                if (!allocate) {
//                    TreeMap<Integer, Node> map = memoryManager.get(right - left);
//                    map.remove(left);
//                    if (map.isEmpty()) {
//                        memoryManager.remove(right - left);
//                    }
//                    leftMap.remove(left);
//                    rightMap.remove(right);
//                }
//            }
//
//            void addSelf() {
//                if (allocate) {
//                    idMap.computeIfAbsent(mid, x -> new ArrayList<>()).add(this);
//                } else {
//                    memoryManager.computeIfAbsent(right - left, x -> new TreeMap<>()).put(left, this);
//                    leftMap.put(left, this);
//                    rightMap.put(right, this);
//                }
//            }
//
//            public Node(int left, int right) {
//                this.left = left;
//                this.right = right;
//            }
//
//            public Node(int left, int right, boolean allocate, int mid) {
//                this.left = left;
//                this.right = right;
//                this.allocate = allocate;
//                this.mid = mid;
//            }
//        }
//
//        public Allocator(int n) {
//            new Node(0, n).addSelf();
//        }
//
//        public int allocate(int size, int mID) {
//            Map.Entry<Integer, TreeMap<Integer, Node>> largerMemoriesEntry = memoryManager.ceilingEntry(size);
//            if (null == largerMemoriesEntry || largerMemoriesEntry.getValue().isEmpty()) {
//                return -1;
//            }
//            TreeMap<Integer, Node> map = largerMemoriesEntry.getValue();
//            Node leftestNode = map.firstEntry().getValue();
//            leftestNode.removeSelf();
//            Node ll = new Node(leftestNode.left, leftestNode.left + size, true, mID);
//            ll.addSelf();
//            if (size < leftestNode.right - leftestNode.left) {
//                Node rr = new Node(leftestNode.left + size, leftestNode.right);
//                rr.addSelf();
//            }
//            return ll.left;
//        }
//
//        public int free(int mID) {
//
//            List<Node> toFrees = idMap.remove(mID);
//            if (null == toFrees) {
//                return 0;
//            }
//
//            int total = 0;
//
//            for (Node toFree : toFrees) {
//                toFree.removeSelf();
//
//                int left = toFree.left, right = toFree.right;
//
//                Node ll = rightMap.get(toFree.left);
//                if (null != ll) {
//                    ll.removeSelf();
//                    left = ll.left;
//                }
//
//                Node rr = leftMap.get(toFree.right);
//                if (null != rr) {
//                    rr.removeSelf();
//                    right = rr.right;
//                }
//
//                new Node(left, right).addSelf();
//
//                total += toFree.right - toFree.left;
//            }
//            return total;
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }

}
