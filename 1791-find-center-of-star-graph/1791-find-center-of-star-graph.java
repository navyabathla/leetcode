class Solution {
    public int findCenter(int[][] edges) {
         int[] first = edges[0]; // {a, b}
        int[] second = edges[1]; // {c, a}

        if (first[0] == second[0] || first[0] == second[1]) {
            return first[0];
        }

        return first[1];
    }
}