class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        System.out.println(map);
        
        for(Character ch : t.toCharArray()) {
            if(map.containsKey(ch)) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch)-1);                    
                }
                    
                
            } else {
                return false;
            }
        }
        
        if(map.size() > 0)
            return false;
        
        return true;
        
    }
}