class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int subStringLen = wordLen * wordCount;
        if (s.length() < subStringLen) return res;

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> currMap = new HashMap<>();

            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);

                if (wordFreq.containsKey(sub)) {
                    currMap.put(sub, currMap.getOrDefault(sub, 0) + 1);
                    count++;

                    while (currMap.get(sub) > wordFreq.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currMap.put(leftWord, currMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == wordCount) {
                        res.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        currMap.put(leftWord, currMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    currMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }
}
