package _0000_0099;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _22 {
	
	public List<String> generateParenthesis(int n) {
		
		if(n==0)
			return Collections.emptyList();

		List<String> ans =new ArrayList<>();
		
		dfs(0,0,0,new char[2*n],n,ans);
		
		return ans;
    }
	
	public void dfs(int l,int ll,int index,char[] tempans,int n,List<String> ans){
		if(index==2*n-1){
			tempans[index]=')';
			ans.add(new String(tempans));
			return;
		}
		if(l==0){
			tempans[index]='(';
			dfs(l+1,ll+1,index+1,tempans,n,ans);
		}else{
			if(ll<n){
				tempans[index]='(';
				dfs(l+1,ll+1,index+1,tempans,n,ans);
			}
			tempans[index]=')';
			dfs(l-1,ll,index+1,tempans,n,ans);
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new _22().generateParenthesis(2));
	}
	
}
