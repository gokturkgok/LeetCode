class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> buffer = new HashMap<>();        
        for(int i=0; i < nums.length ; i++){
            buffer.put(nums[i], i);
        }
        
        for(int j = 0; j < nums.length ; j++){
            if(buffer.containsKey(target-nums[j]) && buffer.get(target-nums[j])!=j){
                return new int[]{ j, buffer.get(target-nums[j]) };
            }
        }
        
        return new int[]{};
        
    }
}