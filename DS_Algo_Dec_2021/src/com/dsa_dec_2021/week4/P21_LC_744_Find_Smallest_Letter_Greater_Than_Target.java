package com.dsa_dec_2021.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class P21_LC_744_Find_Smallest_Letter_Greater_Than_Target {

	/*
	 * Problem Statement:
	 * 
	 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - char[] and char target
	 * What is the expected output? - char
	 * Do I have constraints to solve the problem? - Binary Search
	 *
	 *
	 * 2) Test Data Set
	 *  Minimum of 3 data set !!
	 *   
	 *  Positive : ['c','f','j']  target = 'd'
	 *   
	 *  Edge     : ['c','f','j']  k = 'a'
	 *  
	 *  Negative : ['c','f','j'], k = 'j'
	 *
	 */
	
	
	@Test
	public void test1() {
		char[] letters = {'c','f','j'};
		char target  	 = 'd';
		Assert.assertTrue(nextGreatestLetter(letters, target)=='f');
	}
	
	@Test
	public void test2() {
		char[] letters = {'c','f','j'};
		char target  	 = 'a';
		Assert.assertTrue(nextGreatestLetter(letters, target)=='c');
	}
	
	@Test
	public void test3() {
		char[] letters = {'c','f','j'};
		char target  	 = 'j';
		Assert.assertTrue(nextGreatestLetter(letters, target)=='c');
	}
	
	//Brute Force - O(n)
    public char nextGreatestLetterBruteForce(char[] letters, char target) {
    	for(int i = 0; i<letters.length;i++) 
    		if(letters[i] > target) return letters[i];
    	return letters[0];
    }

    //Binary Search - O(log n)
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;  
        if(target >= letters[high]) return letters[0];
        while(low <= high){
            int mid = (low + high) / 2;
            if(letters[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return letters[low];
    }    
}













