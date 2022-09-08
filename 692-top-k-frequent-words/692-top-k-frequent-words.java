class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        
        for(String word : words)
            freq.put(word, 0);
        
        for(String word : words) {
            freq.put(word, freq.get(word)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(
            (a, b) -> (a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
        );
        
        for(Map.Entry<String, Integer> entry : freq.entrySet()) {
            heap.add(entry);
        }
        
        List<String> res = new ArrayList<String>();
        for(int i = 0 ; i < k; i++) {
            res.add(heap.poll().getKey());
        }
        
        return res;
    }
}