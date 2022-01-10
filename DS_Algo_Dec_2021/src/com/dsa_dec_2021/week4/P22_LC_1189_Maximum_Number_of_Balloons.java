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

public class P22_LC_1189_Maximum_Number_of_Balloons {

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

	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	/*
    1. Delcare a pattern map and collectionMap
    2. Add the pattern occurrence of char in ballon
    3. Traverse the string and add char occurrence to collection map if that char contains in pattern map
    4. Create a infine lopp
    5.   Iterate the pattern map
    6.      if that char exists and char count > 0
    7.           subtract that ocuurrence in collection map
    8.      else break
    9.   count++
    10.return count
	 */


	public int maxNumberOfBalloons(String text) {

		HashMap<Character, Integer> pattern = new HashMap<Character, Integer>();
		pattern.put('b',1);
		pattern.put('a',1);
		pattern.put('l',2);
		pattern.put('o',2);
		pattern.put('n',1);
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] charArray = text.toCharArray();
		for(Character letter : charArray){
			map.put(letter, map.getOrDefault(letter, 0)+1);
		}
		boolean loop = true;
		while(loop){
			for(Map.Entry<Character,Integer> set : pattern.entrySet()){
				if(map.containsKey(set.getKey()) && map.get(set.getKey()) > 0){
					map.put(set.getKey(), map.getOrDefault(set.getKey(), 0)-set.getValue());
					if(map.get(set.getKey()) < 0) {
						loop = false;
						break;
					}
				}else{
					loop = false;
					break;
				}
			}
			count++;
		}
		return count-1;
	}

	public int maxNumberOfBalloons2(String text) {
		
		int count = Integer.MAX_VALUE;
		
		//Assign Default values in map
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('b',0);
		map.put('a',0);
		map.put('l',0);
		map.put('o',0);
		map.put('n',0);
		
		char[] charArray = text.toCharArray();
		
        for(Character letter : charArray){
			map.put(letter, map.getOrDefault(letter, 0)+1);
		}
		//nlaeolko
        //Check number of occurrence by order
        count = Math.min(count, map.get('b'));
        count = Math.min(count, map.get('a'));
        count = Math.min(count, map.get('l')/2);
        count = Math.min(count, map.get('o')/2);
        count = Math.min(count, map.get('n'));
        
		return count;
	}
	
	
	public int maxNumberOfBalloons3(String text) {
		
		int count = Integer.MAX_VALUE;
		
		//Assign Default values in map
		int[] ascii = new int[26];
		
		char[] charArray = text.toCharArray();
		
        for(Character letter : charArray){
			ascii[letter-'a']++;
		}
		
        //Check number of occurrence by order
        count = Math.min(count, ascii['b'-'a']);
        count = Math.min(count, ascii['a'-'a']);
        count = Math.min(count, ascii['l'-'a']/2);
        count = Math.min(count, ascii['o'-'a']/2);
        count = Math.min(count, ascii['n'-'a']);
        
		return count;
	}
}
