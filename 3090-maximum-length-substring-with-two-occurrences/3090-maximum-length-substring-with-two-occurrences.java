class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int left=0;
        int maxl=0;
        int[] freq=new int[26];
        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'a']++;
            while(freq[s.charAt(right)-'a']>2){
                freq[s.charAt(left)-'a']--;
                left++;
            }
            maxl=Math.max(maxl,right-left+1);

        }
        return maxl;
    }
}