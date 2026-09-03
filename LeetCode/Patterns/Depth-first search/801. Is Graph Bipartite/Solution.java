class Solution {
    public boolean isBipartite(int[][] graph) {
         int n = graph.length;

        // -1 = not colored
        // 0 and 1 = two colors
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i =0;i<n;i++){
            if (color[i]==-1){
                 color[i] = 0;
                 if (!dfs(i,graph,color)) return false;
            }
        }
        return true;
    }
     private boolean dfs(int node, int[][] graph, int[] color) {
        for (int neighbour : graph[node]){
            if (color[neighbour]==-1){
                 color[neighbour] = 1 - color[node];

                 if (!dfs(neighbour,graph,color)) return false;
            }
            else if (color[neighbour] == color[node]) {

                return false;
            }

        }
        return true;
     }

}