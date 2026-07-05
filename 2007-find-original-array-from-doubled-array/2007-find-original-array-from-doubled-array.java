class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // Odd length can't be a doubled array
        if (n % 2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store frequency
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : changed) {

            int twice = 2 * num;

            // Skip if already used
            if (map.get(num) == 0) {
                continue;
            }

            // If double doesn't exist
            if (!map.containsKey(twice) || map.get(twice) == 0) {
                return new int[0];
            }

            result.add(num);

            map.put(num, map.get(num) - 1);
            map.put(twice, map.get(twice) - 1);
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;

    }
}