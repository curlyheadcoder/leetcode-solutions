class Solution {
    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean deleted = false;
    }

    TrieNode root = new TrieNode();
    Map<String, List<TrieNode>> serialToNodes = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Step 1: Build Trie
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr = curr.children.computeIfAbsent(folder, k -> new TrieNode());
            }
        }

        // Step 2: Serialize subtrees and collect duplicates
        serialize(root);

        // Step 3: Mark duplicate subtrees for deletion
        for (List<TrieNode> group : serialToNodes.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.deleted = true;
                }
            }
        }

        // Step 4: Collect remaining paths
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";
        List<String> serials = new ArrayList<>();
        for (String childName : node.children.keySet()) {
            TrieNode child = node.children.get(childName);
            serials.add(childName + serialize(child));
        }
        Collections.sort(serials);
        String serial = String.join("", serials);
        serialToNodes.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return "(" + serial + ")";
    }

    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            if (!child.deleted) {
                path.add(folder);
                result.add(new ArrayList<>(path));
                collectPaths(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
