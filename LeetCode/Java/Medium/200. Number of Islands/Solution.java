class Solution {
    public int numIslands(char[][] grid) {
        int row =grid.length;
        int col =grid[0].length;
          int islands = 0;

        for (int i =0;i<row;i++){
            for (int j =0;j<col;j++){
                if(grid[i][j]=='1'){
                    islands++;
                }
                dfs(grid,i,j);
            }
        }  
        return islands;
    }

      private void dfs(char[][] grid, int row, int col) {
        if(row<0 || row>=grid.length||
        col<0 || col>=grid[0].length||
        grid[row][col] =='0')return;
      
     //// Mark this land as visited
      grid[row][col] = '0';

        // Up
        dfs(grid, row - 1, col);

        // Down
        dfs(grid, row + 1, col);

        // Left
        dfs(grid, row, col - 1);

        // Right
        dfs(grid, row, col + 1);
      }
}