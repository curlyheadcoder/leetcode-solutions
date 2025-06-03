/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [][] matrix = new int [m][n];
        // Step 1: Fill matrix with -1
        for(int [] row : matrix){
            Arrays.fill(row, -1);
        }
        // Directions: right, down, left, up
        int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0;        // current direction index
        int r = 0, c = 0;
        while(head != null){
            matrix[r][c] = head.val;
            head = head.next;
            // Next coordinates
            int nextR = r + directions[dir][0];
            int nextC = c + directions[dir][1];
            // Check boundaries and if already filled 
            if(nextR< 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[nextR][nextC] != -1){
                dir = (dir + 1) % 4;   // change direction
                nextR = r + directions[dir][0];
                nextC = c + directions[dir][1];
            }
            r = nextR;
            c = nextC;
        }
        return matrix;
    }
}