class Solution {
     private void reverse(char[] result, int i, int j) {
        while(i < j) {
            char tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        int n = s.length();
        
        char[] result = s.toCharArray();
        
        for (int i = 0; i < n; i++) {
            
            if (result[i] != ' ') {
                int j = i;
                while (j + 1 < n && result[j + 1] != ' ') { 
                    j++; 
                }
                reverse(result, i, j);
                i = j;
            }
        }
        
        return new String(result);
    }
}