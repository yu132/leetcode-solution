package test;

public class Test10e9 {
    public static void main(String[] args) {
        System.out.println((int) 2e9);
        for (int i = 0; i <= 32; ++i) {
            if ((1 << i) > 1e9) {
                System.out.println(i);
                break;
            }
        }
    }
}
