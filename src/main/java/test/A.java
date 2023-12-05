package test;

public class A {


    public static int a(int n) {
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                for (int k = 0; k <= j; ++k) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 1; i < 100; ++i) {
//            ;
//            System.out.println(a(i) + " " + (count += (i * (i + 3) / 2)));
//        }
//        Random r = new Random();
//        int num = 1;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; ++i) {
//            for (int j = 0; j < r.nextInt(10); ++j) {
//                list.add(num);
//            }
//            num += r.nextInt(5);
//        }
//        System.out.println(list);
//        Random r = new Random();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 1000; ++i) {
//            list.add(r.nextInt(101) - 50);
//        }
//        System.out.println(list);
        System.out.println(1000_01 * 1000_01);
        System.out.println(1000_01L * 1000_01);
    }

}
