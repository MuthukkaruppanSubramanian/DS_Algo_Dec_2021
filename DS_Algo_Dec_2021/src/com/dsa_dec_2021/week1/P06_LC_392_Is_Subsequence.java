package com.dsa_dec_2021.week1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class P06_LC_392_Is_Subsequence {

	/*
	 * Problem Statement:
	 * Given two strings s and t, return true if s is a subsequence of t, 
	 * or false otherwise.A subsequence of a string is a new string that is 
	 * formed from the original string by deleting some (can be none) of the 
	 * characters without disturbing the relative positions of the remaining 
	 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - String
	 * What is the expected output? - Boolean 
	 * Do I have constraints to solve the problem? - 
	 * Do I have all informations to go to next step!!
	 * How big is your test data set will be?
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive :  s = "abc", t = "ahbgdc"
	 *   
	 *  Edge     :  s = "abc", t = "ahbbgdc"
	 *  
	 *  Negative :  s = "axc", t = "ahbgdc"
	 *  
	 *  Validate the data set with the interviewer 
	 *
	 * 3) Do I know how to solver it?
	 *	Yes - great, Is there any alternate solution?
	 *	No - Can I break down the problem to sub problems?
	 *
	 * 4) Ask for the hint (If you don't know how to solve it)
	 *
	 *
	 * 5) Do I know alternate solution to solve this problem? - yes
	 *	Yes - What are those? 
	 *	No – That is still fine, proceed to solve by what you know !!
	 *
	 *  Simple Technique - > Brute Force !!
	 *  
	 * 6) If you know alternate solutions -> find out the O Notations (Performance)
	 *  Approach 1:
	 *
	 * 7) Start with Pseudo code
	 * 		a.
	 * 		
	 * 8)Implement the code
	 * 
	 * 9)Test against the different data set
	 * 
	 * 10) If it fails Debug them to solve it !!
	 */
	
	
	
	@Test
	public void test1() {
		String s = "abc", t = "ahbgdc";
		Assert.assertTrue(isSubsequenceOptimized(s,t));
	}
	
	@Test
	public void test2() {
		String s = "abc", t = "ahbbgdc";
		Assert.assertTrue(isSubsequenceOptimized(s,t));
	}
	
	@Test
	public void test3() {
		String s = "abc", t = "ahcgdb";
		Assert.assertFalse(isSubsequenceOptimized(s,t));
	}

	private boolean isSubsequence(String s, String t) {
		int j = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			while(j < t.length() && s.charAt(i)!=t.charAt(j)) j++;
			if(j < t.length()) sb.append(t.charAt(j++));
		}
		return s.equals(sb.toString());
	}

	/*
	 * Approach:Two Pointer
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * Pseudo Code:
	 *  a. Declare left = 0 and right as array length-1
	 *  b. Traverse the given string until its length
	 *  c. if char at left in string s and char at right in string t are same increment left
	 *  d. else by default increment right
	 *  e. compare left == source string s length 
	 *  f. -->if equal then return true since t has the sequence of s.
	 *  g. --> else false
	 */
	private boolean isSubsequenceOptimized(String s, String t) {
		int left = 0, right = 0;
		while(left < s.length() && right < t.length()) {
			if(s.charAt(left)==t.charAt(right))left++;
			right++;
		}
		return left==s.length();
	}
}
