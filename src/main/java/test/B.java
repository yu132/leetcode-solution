/**
 * @Title: B.java
 *
 * @Package test
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 *
 */
package test;

/**  
 * @ClassName: B  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年1月31日  
 *  
 */
public class B {

    public static void main(String[] args) {

        long l = 2l * 3 * 4 * 5 * 6 * 7 * 8;

        for (int i = 0; i < "999999999999999".length() + 1; ++i) {
            l *= 9;
        }
        System.out.println(l);
    }

}
