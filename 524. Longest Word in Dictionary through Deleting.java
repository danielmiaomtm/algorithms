/*
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the 
given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. 
If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
Show Company Tags
Show Tags

*/





public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result="";//initial the result
		for(String K : d){//traverse the dictionary
			int j = 0;//mark, whether finish traversing a dictionary word
			for(int i = 0; i < s.length(); i++){
			    //if s has a letter equals the dictionary word, then move j back
				if(j < K.length() && s.charAt(i) == K.charAt(j)){
					j++;
				}
			}
			if(j == K.length()){//if finish traversing the dictionary word
				if(result != ""){
					if(K.length() > result.length()){//if find a longer word, reset result
						result = K;
					}else if(K.length() == result.length()){ 
					    //if the word is same length of pre result, compare their lexicographical order
						result = result.charAt(0) > K.charAt(0) ? K : result;
					}
				}else{//if nothing contains in the result, reset result
				    result=K;
				}
			}
		}
		return result;
    }
}
