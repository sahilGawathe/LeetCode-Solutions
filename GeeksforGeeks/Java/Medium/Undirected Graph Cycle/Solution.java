class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         
         for (int i =0;i<V;i++){
             adj.add(new ArrayList<>());
         }
             
             for (int [] edge:edges){
                 int u = edge[0];
                 int v = edge[1];
                 
                 adj.get(u).add(v);
                 adj.get(v).add(u);
             }
             
             boolean []visited = new boolean[V];
              for (int i =0;i<V;i++){
                  if (!visited[i]){
                      if (dfs(i, -1, adj, visited)) {
                          return true;
                      }
                  }
              }
              return false;
         }
    
         
         static boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,
         boolean[] visited){
             visited[node] = true;
             
             for (int neighbour: adj.get(node)){
                  if (!visited[neighbour]){
                      if (dfs(neighbour, node, adj, visited)) {
                          return true;
                      }
                  }
             else if (neighbour != parent) {

                          // Cycle found
                          return true;
                      }
             }
             return false;
             
         }
         
    }
