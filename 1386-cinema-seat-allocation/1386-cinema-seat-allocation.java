import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats using bitmask
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        // Initially, every row can accommodate 2 families
        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            boolean left = (mask & 60) == 0;   // seats 2-5
            boolean middle = (mask & 240) == 0; // seats 4-7
            boolean right = (mask & 960) == 0;  // seats 6-9

            if (left && right) {
                ans += 2;
            } 
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}