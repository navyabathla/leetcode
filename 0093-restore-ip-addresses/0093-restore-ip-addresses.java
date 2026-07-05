class Solution {
    private int n;
    private List<String> result;

    private boolean isValid(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }

        int val = Integer.parseInt(str);
        return val <= 255;
    }

    private void solve(String s, int idx, int part, String curr) {
        if (idx == n && part == 4) {
            result.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if (idx >= n || part >= 4) {
            return;
        }

        // Take 1 digit
        if (idx + 1 <= n) {
            solve(s, idx + 1, part + 1,
                    curr + s.substring(idx, idx + 1) + ".");
        }

        // Take 2 digits
        if (idx + 2 <= n && isValid(s.substring(idx, idx + 2))) {
            solve(s, idx + 2, part + 1,
                    curr + s.substring(idx, idx + 2) + ".");
        }

        // Take 3 digits
        if (idx + 3 <= n && isValid(s.substring(idx, idx + 3))) {
            solve(s, idx + 3, part + 1,
                    curr + s.substring(idx, idx + 3) + ".");
        }
    }

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        n = s.length();

        if (n > 12) {
            return result;
        }

        solve(s, 0, 0, "");
        return result;
    }
}