class Solution {
    public String countAndSay(int n) {

        String result = "1";

        // Generate strings from 2 to n
        for (int i = 2; i <= n; i++) {

            StringBuilder next = new StringBuilder();

            int j = 0;

            // Read the current string
            while (j < result.length()) {

                char current = result.charAt(j);
                int count = 0;

                // Count consecutive same characters
                while (j < result.length()
                        && result.charAt(j) == current) {

                    count++;
                    j++;
                }

                // Say what we counted
                next.append(count);
                next.append(current);
            }

            // Move to the next generated string
            result = next.toString();
        }

        return result;
    }
}