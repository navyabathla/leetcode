class Solution {
       private boolean dfs(List<Integer>[] graph, boolean[] visited, int node, int destination) {

        if (node == destination) {
            return true;
        }

        visited[node] = true;

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                if (dfs(graph, visited, neighbor, destination)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }
}