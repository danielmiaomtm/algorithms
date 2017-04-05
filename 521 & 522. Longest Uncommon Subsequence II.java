/*
Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon 
subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the 
other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining 
elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon 
subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc"
Output: 3
Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
because "aba" is a subsequence of "aba", 
but not a subsequence of any other strings in the group of two strings. 
*/




public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                return -1;
            } else {
                return a.length();
            }
        } else {
            return Math.max(a.length(), b.length());
        }
    }
}






/*
Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon subsequence is defined as 
the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining 
elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon
subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc", "eae"
Output: 3
Note:

All the given strings' lengths will not exceed 10.
The length of the given list will be in the range of [2, 50].
*/





public class Solution {

    public int findLUSlength(String[] strs) {
        Set<String> candidateSet = new HashSet<>();
        Set<String> impossibleSet = new HashSet<>();
        for(String s : strs) {
            if(!impossibleSet.contains(s)) {
                if(candidateSet.contains(s)) {
                    candidateSet.remove(s);
                    impossibleSet.add(s);
                } else {
                    boolean isGood = true;
                    for(String impS : impossibleSet) {
                        if(isSubsequence(impS, s)) {
                            isGood = false;
                            break;
                        }
                    }
                    if(!isGood) {
                        candidateSet.remove(s);
                        impossibleSet.add(s);
                    } else {
                        candidateSet.add(s);
                    }
                }
            }
        }
        int res = -1;
        for(String s : candidateSet)
            res = Math.max(res, s.length());
        return res;
    }
    
    private boolean isSubsequence(String origin, String target) {
        if(target.length() > origin.length()) {
            return false;
        } else if(target.length() == origin.length()) {
            return target.equals(origin);
        } else {
            int startI = 0;
            for(int i = 0; i < target.length(); i++) {
                int foundI = origin.indexOf(target.charAt(i), startI);
                if(foundI == -1) {
                    return false;
                }
                startI = foundI + 1;
            }
            return true;
        }
    }
    
}
