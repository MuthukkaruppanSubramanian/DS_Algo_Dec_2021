package com.dsa_dec_2021.week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P08_LC_643_Maximum_Average_Subarray_I {

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
		int[] 	nums = {1,12,-5,-6,50,3};
		int 	target = 4;
		Assert.assertTrue(findMaxAvg(nums, target)==12.75000);
	}
	
	@Test
	public void test2() {
		int[] 	nums = {5};
		int 	target = 1;
		Assert.assertTrue(findMaxAvg(nums, target)==5.00000);		
	}
	
	@Test
	public void test3() {
		int[] 	nums = {-1,-12,-5,-6,-50,-3};
		int 	target = 4;
		Assert.assertTrue(findMaxAvg1(nums, target)== -6.0);
	}
		
	private double findMaxAvg1(int[] nums, int target) {
		double windowSum = 0, maxSum = 0;
		for(int i =0; i<target;i++) {
			windowSum +=nums[i];
		}
		maxSum = windowSum;
		for (int i = target; i < nums.length; i++) {
			windowSum += nums[i] - nums[i-target];
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum/target;
	}
	
	private double findMaxAvg(int[] nums, int target) {
		double max = Integer.MIN_VALUE;
		int sum = 0, j = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(i >= target-1) {
				max = Math.max(max, sum);
				sum -=nums[j++];
			}
		}
		return max/target;
	}
	
}









