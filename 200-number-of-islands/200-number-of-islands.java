class Solution {
    
    private static class Coordinate {
        int r;
        int c;
        
        public Coordinate(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    private static List<Coordinate> getNeighbors(Coordinate coord, int numRows, int numCols) {
        List<Coordinate> neighbors = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        
        for(int i = 0; i < deltaRow.length; i++){
            int neighborRow = coord.r + deltaRow[i];
            int neighborCol = coord.c + deltaCol[i];
            
            if(neighborRow >= 0 && neighborRow < numRows && neighborCol >= 0 && neighborCol < numCols) {
                neighbors.add(new Coordinate(neighborRow, neighborCol));
            }
            
        }
        return neighbors;
    }
    
    private static void bfs(char[][] grid, Coordinate root, int numRows, int numCols ) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        grid[root.r][root.c] = 0;
        
        while( queue.size() > 0 ) {
            Coordinate node = queue.pop();
            List<Coordinate> neighborList = getNeighbors(node, numRows, numCols);
            
            for(Coordinate neighbor : neighborList) {
                if(grid[neighbor.r][neighbor.c]=='0')
                    continue;
                queue.add(neighbor);
                grid[neighbor.r][neighbor.c] = '0';
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numOfIslands = 0;
        for(int r = 0; r < numRows; r++) {
            for(int c = 0; c < numCols; c++) {
                if(grid[r][c]=='0')
                    continue;
                bfs(grid, new Coordinate(r, c), numRows, numCols);
                numOfIslands++;
            }
        }
        
        return numOfIslands;
    
    }
}