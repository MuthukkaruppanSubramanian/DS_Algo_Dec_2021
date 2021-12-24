package com.dsa_dec_2021.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class P09_LC_1763_Longest_Nice_Substring {

	/*
	 * Problem Statement:
	 * 
	 * You are given an integer array nums consisting of n elements, 
	 * and an integer k. Find a contiguous subarray whose length is equal 
	 * to k that has the maximum average value and return this value.
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - int[]
	 * What is the expected output? - double 
	 * Do I have constraints to solve the problem? - Slinding Window
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : [1,12,-5,-6,50,3]  k = 4
	 *   
	 *  Edge     : [5] , k = 1
	 *  
	 *  Negative : [2,3,4], k = 4
	 *
	 */
	
	
	
	@Test
	public void test1() {
		System.out.println(longestNiceSubstring("abABrsaAdDzZ"));
	}
	
	@Test
	public void test2() {
		System.out.println(longestNiceSubstring("Y"));
	}
	
	@Test
	public void test3() {
		System.out.println(longestNiceSubstring("YaaaAAy"));
	}
	
	
	public String longestNiceSubstring(String s) {
		int max = 0;
		String output = "";
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder(s.charAt(i)+"");
			for (int j = i+1; j < s.length(); j++) {
				sb.append(s.charAt(j));
				if(niceString(sb.toString())) {
					if(max <j-i+1) {
						max = j-i+1;
						output = sb.toString();
					}
				}
			}
		}
		return output;
	}

	public boolean niceString(String sb) {
		String s = sb;//abAB
		for (int i = 0; i < s.length(); i++) {
			if((Character.isUpperCase(s.charAt(i)))) { //a
				if(!s.contains((Character.toLowerCase(s.charAt(i))+""))) // 
					return false;				
			}else { //a -> A
				if(!s.contains((Character.toUpperCase(s.charAt(i))+""))) 
					return false;
			}
		}
		return true;
	}
	
	
}






















