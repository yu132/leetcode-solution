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
        int count = 0;
        for (int i = 1; i < 100; ++i) {
            ;
            System.out.println(a(i) + " " + (count += (i * (i + 3) / 2)));
        }
    }

}
