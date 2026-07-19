class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int openBrackets = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBrackets++;
            } else if (ch == ')') {
                openBrackets--;
            }
            
            result = Math.max(result, openBrackets);
        }
        
        return result;
    }
}