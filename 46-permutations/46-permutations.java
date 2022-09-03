class Solution {
    
    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] used, ArrayList<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i=0; i < nums.length; i++) {
            if(used[i])
                continue;
            
            path.add(nums[i]);
            used[i] = true;
            
            dfs(res, nums, used, path);
            
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