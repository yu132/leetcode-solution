package _0_99;

public class _58 {

	public int lengthOfLastWord(String s) {
        String[] sp=s.trim().split(" ");
        return sp[sp.length-1].length();
    }
	
	public static void main(String[] args) {
		System.out.println(new _58().lengthOfLastWord(" 12"));
	}
}
