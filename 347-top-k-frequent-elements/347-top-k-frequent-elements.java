class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> (e2.getValue()-e1.getValue()));
        
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            heap.add(entry);
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = heap.poll().getKey();
        
        return res;
    }
}