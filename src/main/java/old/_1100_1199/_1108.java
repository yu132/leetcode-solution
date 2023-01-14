package old._1100_1199;

public class _1108 {
	
	class Solution {
		public String defangIPaddr(String address) {
			char[]	nip		= new char[address.length() + 2 * 3];
			int		index	= 0;
			for (char each : address.toCharArray()) {
				if (each == '.') {
					nip[index++]	= '[';
					nip[index++]	= '.';
					nip[index++]	= ']';
				} else {
					nip[index++] = each;
				}
			}
			return String.valueOf(nip);
		}
	}
	
}
