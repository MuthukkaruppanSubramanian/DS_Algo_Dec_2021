package com.dsa_dec_2021.week2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P12_LC_209_Minimum_Size_SubArray_Sum {

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
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		System.out.println(minSubArrayLen(target, nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,3,4,5};
		int target = 11;
		System.out.println(minSubArrayLen(target, nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {2,3,1,2,4,3};
		int target = 100;
		System.out.println(minSubArrayLen(target, nums));
	}
	
    public int minSubArrayLen(int target, int[] nums) {
		int min = Integer.MAX_VALUE;
		int sum = 0, j = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
            while(sum >= target){
                min = Math.min(min, i-j+1);
                sum -=nums[j++];
            }
		}
		return (min == Integer.MAX_VALUE)? 0 : min;
    }

}








