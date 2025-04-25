import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map of t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window
        Map<Character, Integer> windowMap = new HashMap<>();
        int required = targetMap.size();  // Number of unique characters in t
        int formed = 0;  // Number of characters in the current window that match the target frequency
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = -1, minRight = -1;  // To store the result window

        while (right < s.length()) {
            // Expand the window by moving the right pointer
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If current character matches target character frequency, increase formed
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // If we have a valid window, try shrinking the window
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Save the smallest window and update minLen
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }

                // Shrink the window from the left
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand the window by moving the right pointer
            right++;
        }

        // If no valid window found
        if (minLeft == -1) {
            return "";
        }

        return s.substring(minLeft, minRight + 1);
    }
}
