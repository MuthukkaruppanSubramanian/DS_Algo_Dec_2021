package com.dsa_dec_2021.week2;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P11_LC_219_Contains_Duplicate_II {

	/*
	 * Problem Statement:
	 *  https://leetcode.com/problems/contains-duplicate-ii/
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
	 *  Positive : [0,1,2,3,2,5]  k = 3
	 *   
	 *  Edge     : [99,99] , k = 2
	 *  
	 *  Negative : [0,1,2,3,4,5], k = 0
	 *
	 */
	
	
	@Test
	public void test1() {
		int[] nums = {0,1,2,3,2,5};
		int k = 3;
		System.out.println(containsNearbyDuplicate(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {99,99};
		int k = 2;
		System.out.println(containsNearbyDuplicate(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {0,1,2,3,4,5};
		int k = 0;
		System.out.println(containsNearbyDuplicate(nums, k));
	}
  
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> numbers = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(numbers.containsKey(nums[i]) && i-numbers.get(nums[i]) <= k) return true;
            numbers.put(nums[i],i);
        }
        return false;
    }
}
