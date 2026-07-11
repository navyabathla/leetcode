class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        List<String> stack = new ArrayList<>();

        for (String token : tokens) {

            if (token.equals("") || token.equals(".")) {
                continue;
            }

            if (!token.equals("..")) {
                stack.add(token);
            } else if (!stack.isEmpty()) {
                stack.remove(stack.size() - 1);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String token : stack) {
            result.append("/").append(token);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}