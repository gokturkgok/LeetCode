class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                    /*distance*/
                if(a[3] != b[3])
                    return a[3] - b[3];
                
                    /*price*/
                if(a[0] != b[0])  
                    return a[0] - b[0];
                
                    /*row*/
                if(a[1] != b[1])
                    return a[1] - b[1];
                
                    /*column*/
                return a[2] - b[2];
            }
        });
        
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{start[0], start[1]});
        q.offer(new int[]{-1, -1});
        
        int dist = 0;
        
            /*BFS*/
        
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.poll()[1];
            
            if(r >= 0 && c >= 0){
                if(visited[r][c])
                    continue;
                
                if(grid[r][c] > 1 && (grid[r][c] >= pricing[0] && grid[r][c] <= pricing[1]))
                    pq.offer(new int[]{grid[r][c], r, c, dist});

                visited[r][c] = true;

                for(int[] dir: dirs){
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0)
                        continue;

                    q.offer(new int[]{row, col});
                }
            }
            else{
                dist++;
                
                if(!q.isEmpty())
                    q.offer(new int[]{-1, -1});
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        while(!pq.isEmpty() && k-- > 0){
            List<Integer> l = new ArrayList<>();
            
            l.add(pq.peek()[1]);
            l.add(pq.poll()[2]);
            
            res.add(new ArrayList<>(l));
        }
        
        return res;
    }
}