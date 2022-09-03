class Solution {
    
    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] used, ArrayList<Integer> path){
        // identified state
        if(path.size() == nums.length){
            // report state
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i=0; i < used.length; i++) {
            if(used[i])
                continue;
            
            // make move
            path.add(nums[i]);
            used[i] = true;
            
            dfs(res, nums, used, path);
            
            // backtracking
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(res, nums, used, new ArrayList<Integer>());
        return res;
    }
}