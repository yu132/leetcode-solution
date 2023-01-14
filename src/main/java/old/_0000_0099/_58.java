package old._0000_0099;

public class _58 {

	public int lengthOfLastWord(String s) {
        String[] sp=s.trim().split(" ");
        return sp[sp.length-1].length();
    }
	
	public static void main(String[] args) {
		System.out.println(new _58().lengthOfLastWord(" 12"));
	}
}
