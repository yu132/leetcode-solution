package _0000_0099;

import java.util.ArrayList;

public class _06 {

	public static String convert(String s, int numRows) {
		if(s.length()==0||numRows==1)
			return s;
		
		ArrayList[] lists=new ArrayList[numRows];
		
		for(int i=0;i<lists.length;i++)
			lists[i]=new ArrayList<Character>();
		
		boolean flag=false;
		int index=0;
		
		lists[0].add(s.charAt(0));
		for(int i=1;i<s.length();i++){
			if(index==0||index==numRows-1)
				flag=!flag;
			if(flag)
				index++;
			else
				index--;
			
			lists[index].add(s.charAt(i));
		}
		
		StringBuilder sb=new StringBuilder(s.length());
		
		for(int i=0;i<lists.length;i++){
			for(int j=0;j<lists[i].size();j++){
				sb.append(lists[i].get(j));
			}
		}
		
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",4));
	}
}
