/*
Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the
player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. 
This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 
can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.
*/



good explaination
https://www.youtube.com/watch?v=WxpIHvsu1RI



public class Solution {
    public boolean PredictTheWinner(int[] nums) {
         // // even, always win
        // if(nums.length % 2 == 0) return true;
        
        int n = nums.length;
        // maximum score play1 can get
        int[][] dp = new int[n][n];
        int sum = 0;
        // base cases
        for(int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }
        for(int i = 1; i < n; i++) {
            dp[i-1][i] = Math.max(nums[i-1], nums[i]);
        }
        // dp recur
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 2; j <n; j++) {
                int a = Math.min(dp[i+1][j-1], dp[i+2][j]) + dp[i][i];
                int b = Math.min(dp[i][j-2], dp[i+1][j-1]) + dp[j][j];
                dp[i][j] = Math.max(a, b);
            }
        }
        
        return dp[0][n-1] >= sum - dp[0][n-1];
    }
}
