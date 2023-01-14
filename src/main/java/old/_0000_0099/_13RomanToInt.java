package old._0000_0099;

public class _13RomanToInt {
	public int romanToInt(String s) {
        
		int ans=0;
		
		for(int i=0;i<s.length();i++){
			switch(s.charAt(i)){
			case 'M':
				ans+=1000;
				break;
			case 'D':
				ans+=500;
				break;
			case 'C':
				if(i+1>=s.length())
					ans+=100;
				else
					switch(s.charAt(i+1)){
					case 'M':
						ans+=900;
						i++;
						break;
					case 'D':
						ans+=400;
						i++;
						break;
					default:
						ans+=100;
					}
				break;
			case 'L':
				ans+=50;
				break;
			case 'X':
				if(i+1>=s.length())
					ans+=10;
				else
					switch(s.charAt(i+1)){
					case 'C':
						ans+=90;
						i++;
						break;
					case 'L':
						ans+=40;
						i++;
						break;
					default:
						ans+=10;
					}
				break;
			case 'V':
				ans+=5;
				break;
			case 'I':
				if(i+1>=s.length())
					ans+=1;
				else
					switch(s.charAt(i+1)){
					case 'X':
						ans+=9;
						i++;
						break;
					case 'V':
						ans+=4;
						i++;
						break;
					default:
						ans+=1;
					}
				break;
			}
		}
		
		return ans;
    }
	
	public static void main(String[] args) {
		for(int i=1;i<=3999;i++){
			if(new _13RomanToInt().romanToInt(new _12_intToRoman().intToRoman(i))!=i)
				System.out.println(i);
		}
		//System.out.println(new _13().romanToInt("III"));
	}
}
