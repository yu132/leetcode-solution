package test;

public class ArrCast {

    static class A<T> {
        T[] obj = (T[]) new Object[10];

        void set(T t) {
            obj[0] = t;
        }

        T get() {
            return obj[0];
        }

        T[] getArr() {
            return obj;
        }
    }

//    public static void main(String[] args) {
//        A<Integer> a = new A<>();
//        System.out.println(a.get());
//        a.set(1);
//        System.out.println(a.get());
//        Integer[] x = a.getArr();
//        System.out.println(x);
//        x[0] = 1;
//    }

    public static void main(String[] args) {
        Object[] arr = new Object[1];
        System.out.println((Integer[]) arr);
        ((Integer[]) arr)[0] = 1;
    }

//    public static void main(String[] args) {
//        new Solution().a();
//    }
//
//    static
//            //
//    class Solution {
//
//        void a() {
//            Solution.B<Solution.Node> b = new Solution.B<>();
//            b.get()[0] = new Node();
//            System.out.println(b.get());
//        }
//
//
//        class Node {
//        }
//
//        static class B<T> {
//            A<T> a;
//
//            B() {
//                a = new A<>(10);
//            }
//
//            T[] get() {
//                return a.val;
//            }
//
//            static class A<T> {
//                T[] val;
//
//                public A(int len) {
//                    this.val = (T[]) new Object[len];
//                }
//            }
//        }
//    }


}
