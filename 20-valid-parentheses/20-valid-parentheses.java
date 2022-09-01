class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> paranthesesMap = new HashMap<>();
        paranthesesMap.put('(', ')');
        paranthesesMap.put('{', '}');
        paranthesesMap.put('[', ']');
        
        Stack<Character> checkStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(paranthesesMap.containsKey(currentChar)){
                checkStack.push(currentChar);
            } else {
                if(checkStack.isEmpty()){
                    return false;
                }
                char matchingChar = checkStack.pop();
                if(currentChar != paranthesesMap.get(matchingChar))
                    return false;
            }
        }
        
        if(!checkStack.isEmpty()){
            return false;
        }
        
        return true;
        
    }
}