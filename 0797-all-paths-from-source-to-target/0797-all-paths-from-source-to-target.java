class Solution {
        private List<List<Integer>> result = new ArrayList<>();

    private void dfs(int[][] graph, int node, List<Integer> path) {

        path.add(node);

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {

            for (int next : graph[node]) {
                dfs(graph, next, path);
            }
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        dfs(graph, 0, new ArrayList<>());

        return result;
    }
}