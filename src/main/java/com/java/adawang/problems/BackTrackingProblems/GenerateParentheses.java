package com.java.adawang.problems.BackTrackingProblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	// # 22
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		if(n==0){
			ans.add("");
		}else{
			for(int c = 0; c < n; c++)
				for(String left : generateParenthesis(c))
					for(String right: generateParenthesis(n-c-1))
						ans.add("("+left+")"+right);
		}
		return ans;
	}

	public List<String> generateParenthesisBackTrack(int n) {
		List<String> ans = new ArrayList();
		backtrack(ans, new StringBuilder(), 0, 0, n);
		return ans;
	}

	public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
		if (cur.length() == max * 2) {
			ans.add(cur.toString());
			return;
		}

		if (open < max) {
			cur.append("(");
			backtrack(ans, cur, open+1, close, max);
			cur.deleteCharAt(cur.length() - 1);
		}
		if (close < open) {
			cur.append(")");
			backtrack(ans, cur, open, close+1, max);
			cur.deleteCharAt(cur.length() - 1);
		}
	}
}
