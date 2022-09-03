class Solution {
    
    
    private static final Map<Character, char[]> KEYBOARD = Map.of(
        '2', "abc".toCharArray(),
        '3', "def".toCharArray(),
        '4', "ghi".toCharArray(),
        '5', "jkl".toCharArray(),
        '6', "mno".toCharArray(),
        '7', "pqrs".toCharArray(),
        '8', "tuv".toCharArray(),
        '9', "wxyz".toCharArray()
    );
    
    
    private static void dfs(List<String> res, char[] digits, StringBuilder path) {
        if(path.length()==digits.length) {
            res.add(path.toString());
            return;
        }
        
        char next_digit = digits[path.length()];
        
        for(char letter : KEYBOARD.get(next_digit)) {
            path.append(letter);
            dfs(res, digits, path);
            path.deleteCharAt(path.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() > 0)
            dfs(res, digits.toCharArray(), new StringBuilder());
        return res;
    }
}