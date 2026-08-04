class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> subset) {

        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);

            backtrack(nums, i + 1, subset);

            subset.remove(subset.size() - 1);
        }
    }
}