package com.dsa_dec_2021.week3;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P19_LC_532_K_Diff_Pairs_In_An_Array {
	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
	 */
	@Test
	public void test1() {
		int[] nums = {3,1,4,1,5};
		int k = 2;
		System.out.println(findPairs(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,3,4,5};
		int k = 1;
		System.out.println(findPairs(nums, k));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,3,1,5,4};
		int k = 0;
		System.out.println(findPairs(nums, k));
	}

    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> outputSet = new HashSet<Integer>();
        int pairs = 0;
        for(int i : nums){
            if((!set.add(i)) && (k == 0)){
              if (!outputSet.contains(i)){
                    pairs++;
                    outputSet.add(i);
              }
            } 
        }
        if(k!=0) {
            for(int i : set){
                if(set.contains(i+k)) pairs++;
            }            
        }
        return pairs;
    }
}
