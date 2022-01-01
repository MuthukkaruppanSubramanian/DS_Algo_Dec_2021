package com.dsa_dec_2021.week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class P14_LC_210_Rings_And_Rods {

	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/rings-and-rods/
	 *
	 *  
	 * 1) Did I understand the problem? Yes or No !! - Yes 
	 * -> If No, Ask the person to provide more detail with example(s) 
	 * -> If yes, go to next step !!
	 * 
	 * What is the input(s)? - String
	 * What is the expected output? - int 
	 * Do I have constraints to solve the problem? - HashMap
	 * 
	 * Time / Space Complexity: O(n) / O(n)
	 */
	
	@Test
	public void test1() {
		Assert.assertTrue(countPoints("G3R3R7B7R5B1G8G4B3G6")==1);
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(countPoints("G3R3B3")==1);		
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(countPoints("B0B6G0R6R1R6G9")==0);
	}
		
    public int countPoints(String rings) {
        int left = 0, right = 1, count = 0;
        HashMap<Character,Set<Character>> rods = new HashMap<Character,Set<Character>>();
        Set<Character> rodQualified = new HashSet<Character>();
        while(right < rings.length()){
            if(rods.containsKey(rings.charAt(right))) 
                rods.get(rings.charAt(right)).add(rings.charAt(left));
            else{
                Set<Character> color = new HashSet<Character>();
                color.add(rings.charAt(left));
                rods.put(rings.charAt(right),color);
            }
            if(rods.get(rings.charAt(right)).size() == 3){
                if(rodQualified.add(rings.charAt(right))) count++;
            }
            left+=2;right+=2;
        }
        return count;
    }
    
    public int countPointsOptimized(String rings) {
        int left = 0, right = 1, count = 0;
        HashMap<Character,Set<Character>> rods = new HashMap<Character,Set<Character>>();
        Set<Character> rodQualified = new HashSet<Character>();
        while(right < rings.length()){
        	
        	//If the rod doesn't exists add to rods map and create new set
            rods.putIfAbsent(rings.charAt(right),new HashSet<Character>());
            
            //Add the color to that set of that rod
            rods.get(rings.charAt(right)).add(rings.charAt(left));
            
            //If size of set == 3 and if that rod not available in rodQualified set
            //increase the count
            if(rods.get(rings.charAt(right)).size() == 3 && rodQualified.add(rings.charAt(right))) count++;
            left+=2;right+=2;
        }
        return count;
    }
}
