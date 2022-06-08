package _0000_0099;

import java.util.ArrayList;

public class _38 {

	public String countAndSay(int n) {
        
		ArrayList<Character> s1=new ArrayList<>();
		ArrayList<Character> s2=new ArrayList<>();
		
		s1.add('1');
		
		boolean ef=true;
		
		for(int i=0;i<n-1;i++){
			
			ArrayList<Character> from,to;
			if(ef){
				from=s1;
				to=s2;
			}else{
				from=s2;
				to=s1;
			}
			ef=!ef;
			
			to.clear();
			
			Character c=from.get(0);
			int count=1;
			
			for(int j=1;j<from.size();j++){
				if(from.get(j)!=c){
					to.add((char)(count+'0'));
					to.add(c);
					c=from.get(j);
					count=1;
				}else{
					count++;
				}
			}
			
			to.add((char)(count+'0'));
			to.add(c);
			
		}
		
		ArrayList<Character> ans;
		if(ef)
			ans=s1;
		else
			ans=s2;
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ans.size();i++){
			sb.append(ans.get(i));
		}
		
		return sb.toString();
			
    }
	
	public static void main(String[] args) {
		System.out.println(new _38().countAndSay(20));
	}
	
}
