package redo.Util.ag.subSeq.longestPalindrome;

/*
 * @see P516
 * 最长回文子序列 可使用动规解决
 * 从i-j的最长回文串可由子序列转换
 * 若s[i] == s[j], 那么dp[i][j] = dp[i+1][j-1] + 2
 * 若s[i] != s[j], 那么dp[i][j] = max(dp[i+1][j], dp[i][j-1])
 * 从短到长扩展即可，初始dp[i][i] = 1
 */