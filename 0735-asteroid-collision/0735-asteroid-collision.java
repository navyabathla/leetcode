class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         List<Integer> stack = new ArrayList<>();

        for (int asteroid : asteroids) {

            while (!stack.isEmpty() &&
                   asteroid < 0 &&
                   stack.get(stack.size() - 1) > 0) {

                int sum = asteroid + stack.get(stack.size() - 1);

                if (sum < 0) {
                    stack.remove(stack.size() - 1);
                } else if (sum > 0) {
                    asteroid = 0;
                    break;
                } else {
                    stack.remove(stack.size() - 1);
                    asteroid = 0;
                }
            }

            if (asteroid != 0) {
                stack.add(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}