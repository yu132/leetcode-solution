package _700_799;

public class _796 {
	
	class Solution {
		public boolean rotateString(String A, String B) {
			return A.length() == B.length() ? (A + A).contains(B) : false;
		}
	}
	
}
