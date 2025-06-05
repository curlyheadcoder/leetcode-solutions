class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            mergeGroups(parent, u, v);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int groupRep = getLeader(parent, ch - 'a');
            result.append((char)(groupRep + 'a'));
        }

        return result.toString();
    }

    private int getLeader(int[] parent, int ch) {
        if (parent[ch] != ch) {
            parent[ch] = getLeader(parent, parent[ch]);
        }
        return parent[ch];
    }

    private void mergeGroups(int[] parent, int a, int b) {
        int rootA = getLeader(parent, a);
        int rootB = getLeader(parent, b);
        if (rootA == rootB) return;
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}