package level1;

public class Num02 {

	/*
	 * level1 가운데 글자 가져오기 
	 * https://programmers.co.kr/learn/courses/30/lessons/12903
	 */

	class Solution {
	    public String solution(String s) {
	    	int mid = s.length()/2;
	    	
	        String answer = "";
	    	if(s.length()%2 == 0) { //짝수
	    		answer = s.substring(mid-1, mid+1);
	    	}else { //홀수
	    		answer = s.substring(mid, mid+1);
	    	}
	  
	        return answer;
	    }
    }
}
