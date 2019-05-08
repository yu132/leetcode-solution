package _0_99;

import java.util.ArrayList;
import java.util.List;

public class _05 {
/* v1
	static class TWO{
		int a;
		int b;
		public TWO(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}
	 public static String longestPalindrome(String s) {
		 List<TWO> list=new ArrayList<>();
		 
		 int max=0;
		 int maxIndex=-1;
		 
		 for(int i=0;i<s.length();i++){
			 list.add(new TWO(i,i));
		 }
		 
		 if(list.size()!=0){
			 max=1;
			 maxIndex=0;
		 }
		 
		 int tempsize=list.size();
		 
		 for(int i=0;i<s.length()-1;i++){
			 if(s.charAt(i)==s.charAt(i+1)){
				 list.add(new TWO(i,i+1));
			 }
		 }
		 
		 if(list.size()!=tempsize){
			 max=2;
			 maxIndex=tempsize;
		 }
		 
		 for(int i=0;i<list.size();i++){
			 TWO temp=list.get(i);
			 int a=temp.a-1;
			 int b=temp.b+1;
			 if(a<0||b>=s.length())
				 continue;
			 if(s.charAt(a)==s.charAt(b)){
				 list.add(new TWO(a,b));
				 if(b-a+1>max){
					 max=b-a;
					 maxIndex=list.size()-1;
				 }
			 }
		 }		
		 
		 TWO x=list.get(maxIndex);
		 return s.substring(x.a, x.b+1);
	 }
	 
	 public static void main(String[] args) {
		System.out.println(longestPalindrome("aba"));
	}*/
	
	class Solution {
	    public String longestPalindrome(String s) {
	        if(s.equals("")||s==null)
				return s;
	        
	        int start = 0, end = 0;
	        for(int i=0;i<s.length();i++){
	            int l1=expand(s,i,i);
	            int l2=expand(s,i,i+1);
	            int len = Math.max(l1, l2);

	            if (len>end-start) {
	                start=i-(len-1)/2;
	                end=i+len/2;
	            }
	        }
	        return s.substring(start, end + 1);			
	    }

	    public int expand(String s,int l, int r){
	        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
	            l--;
	            r++;
	        }
	        return r-l-1;
	    }
	}
}
