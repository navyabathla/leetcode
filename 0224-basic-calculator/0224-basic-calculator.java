class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (ch == '(') {
                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                // Reset for the new expression
                result = 0;
                number = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                // Complete current expression
                result += sign * number;
                number = 0;

                // Multiply by sign before '('
                result *= stack.pop();

                // Add previous result
                result += stack.pop();
            }
        }

        // Add the last number
        result += sign * number;

        return result;
    }
}