class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;
        int j = 0;
        int n = pushed.length;

        while (i < n && j < n) {

            stack.push(pushed[i]);

            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

            i++;
        }

        return stack.isEmpty();
    }
}