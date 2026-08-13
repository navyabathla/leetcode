class Solution {

    class Node {
        int len;
        int prefix;
        int suffix;
        int best;
        char leftChar;
        char rightChar;

        Node(int len, int prefix, int suffix, int best,
             char leftChar, char rightChar) {

            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    char[] str;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();

        str = s.toCharArray();

        tree = new Node[4 * n];

        // Build segment tree
        build(1, 0, n - 1);

        int q = queryIndices.length;
        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Update the actual string
            str[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index, ch);

            // Root contains answer for entire string
            answer[i] = tree[1].best;
        }

        return answer;
    }

    // Build the segment tree
    private void build(int node, int left, int right) {

        if (left == right) {

            char ch = str[left];

            tree[node] = new Node(
                1,      // len
                1,      // prefix
                1,      // suffix
                1,      // best
                ch,     // leftChar
                ch      // rightChar
            );

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Update one character
    private void update(int node, int left, int right,
                        int index, char ch) {

        if (left == right) {

            tree[node] = new Node(
                1,
                1,
                1,
                1,
                ch,
                ch
            );

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two adjacent segments
    private Node merge(Node left, Node right) {

        int len = left.len + right.len;

        char leftChar = left.leftChar;
        char rightChar = right.rightChar;

        // Initially, the best answer is inside either child
        int best = Math.max(left.best, right.best);

        // Prefix
        int prefix = left.prefix;

        // If the entire left segment has the same character
        // and it matches the beginning of the right segment,
        // prefix can extend into the right segment.
        if (left.prefix == left.len &&
            left.rightChar == right.leftChar) {

            prefix = left.len + right.prefix;
        }

        // Suffix
        int suffix = right.suffix;

        // If the entire right segment has the same character
        // and it matches the end of the left segment,
        // suffix can extend into the left segment.
        if (right.suffix == right.len &&
            left.rightChar == right.leftChar) {

            suffix = right.len + left.suffix;
        }

        // Check if a repeating sequence crosses the boundary
        if (left.rightChar == right.leftChar) {

            best = Math.max(
                best,
                left.suffix + right.prefix
            );
        }

        return new Node(
            len,
            prefix,
            suffix,
            best,
            leftChar,
            rightChar
        );
    }
}