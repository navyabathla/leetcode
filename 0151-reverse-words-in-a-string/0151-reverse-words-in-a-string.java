class Solution {
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public String reverseWords(String s) {
         char[] arr = s.toCharArray();
        int n = arr.length;

        // Reverse the whole string
        reverse(arr, 0, n - 1);

        int i = 0;
        int left = 0;
        int right = 0;

        while (i < n) {

            // Skip spaces
            while (i < n && arr[i] == ' ') {
                i++;
            }

            // Copy the current word
            while (i < n && arr[i] != ' ') {
                arr[right++] = arr[i++];
            }

            // Reverse the copied word
            if (left < right) {
                reverse(arr, left, right - 1);

                // Add a space only if there are more words left
                while (i < n && arr[i] == ' ') {
                    i++;
                }

                if (i < n) {
                    arr[right++] = ' ';
                }

                left = right;
            }
        }

        return new String(arr, 0, right);
    }
}