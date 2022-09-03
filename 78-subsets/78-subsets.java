class Solution {
    
    private static void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> path, int index) {
        if(nums.length==index){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        path.add(nums[index]);    
        dfs(res, nums, path, index+1);
        path.remove(path.size()-1);
        dfs(res, nums, path, index+1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>(), 0);    
        return res;
    }
}